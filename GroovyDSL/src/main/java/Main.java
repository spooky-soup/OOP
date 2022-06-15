import objects.Group;
import objects.Student;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        ConfigReader configReader = new ConfigReader();
        //Student student = new Student();
        Group group = new Group();
        configReader.configure("src/main/java/groupConfig.groovy", group);
        group.postProcess();
        System.out.println(group);
    }
}
