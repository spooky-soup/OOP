package objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Group extends GroovyConfigurable {
    private String name;
    private List<Student> students;
}
