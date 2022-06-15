package objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends GroovyConfigurable {
    private String userName;
    private String fullName;
    private String githubURL;
}
