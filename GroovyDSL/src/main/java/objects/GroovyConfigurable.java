package objects;

import groovy.lang.Closure;
import groovy.lang.GroovyObjectSupport;
import groovy.lang.MetaProperty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public class GroovyConfigurable extends GroovyObjectSupport {

    public void postProcess() throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        for (MetaProperty metaProperty : getMetaClass().getProperties()) {
            Object value = getProperty(metaProperty.getName());
            if (Collection.class.isAssignableFrom(metaProperty.getType()) &&
                    value instanceof Collection) {
                // у коллекции тип всегда параметризован
                ParameterizedType collectionType = (ParameterizedType) getClass().getDeclaredField(metaProperty.getName()).getGenericType();
                // если в объявлении коллекции был не класс, а интерфейс, это работать не будет, и нужна более
                // сложная проверка, но для демонстрации оставим так
                Class itemClass = (Class) collectionType.getActualTypeArguments()[0];
                // развернем замыкания только в том случае, если в коллекции должны лежать объекты objects.GroovyConfigurable
                // для других типов, возможно, понадобится другой код
                if (GroovyObjectSupport.class.isAssignableFrom(itemClass)) {
                    Collection collection = (Collection) value;
                    // мы не знаем конкретный класс коллекции, поэтому создадим такой же, какой уже у этого поля
                    Collection newValue = collection.getClass().newInstance();
                    for (Object o : collection) {
                        if (o instanceof Closure) {
                            // создадим делегата и выполним код
                            Object item = itemClass.getConstructor().newInstance();
                            ((Closure) o).setDelegate(item);
                            ((Closure) o).setResolveStrategy(Closure.DELEGATE_FIRST);
                            ((Closure) o).call();
                            ((GroovyConfigurable) item).postProcess(); // вдруг там внутри тоже коллекции?
                            newValue.add(item);
                        } else {
                            newValue.add(o);
                        }
                    }
                    setProperty(metaProperty.getName(), newValue);
                }
            }
        }
    }
}
