package objects;

import groovy.lang.GroovyObjectSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
public class Mark extends GroovyObjectSupport {
    private String name;
    private LocalDateTime date;
}
