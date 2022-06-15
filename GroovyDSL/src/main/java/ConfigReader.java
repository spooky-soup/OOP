import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.GroovyObjectSupport;
import groovy.util.DelegatingScript;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigReader {
    public void configure(String filePath, GroovyObjectSupport config) throws IOException {
        CompilerConfiguration cc = new CompilerConfiguration();
        cc.setScriptBaseClass(DelegatingScript.class.getName()); // благодаря этой настройке все создаваемые groovy скрипты будут наследоваться от DelegatingScript
        GroovyShell sh = new GroovyShell(Main.class.getClassLoader(), new Binding(), cc);
        DelegatingScript script = (DelegatingScript) sh.parse(new File(filePath));
        //ServerConfig config = new ServerConfig(); // наш бин с конфигурацией
        script.setDelegate(config);
// благодаря предыдущей строчке run() выполнится "в контексте" объекта config и присвоит ему поля name и description
        script.run();
    }
}
