package objects;

import groovy.lang.GroovyObjectSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Task extends GroovyObjectSupport {
    private String id;
    private String name;
    private int points;
}
