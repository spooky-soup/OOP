package objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class CurrentTask extends GroovyConfigurable {
    private String id;
    private LocalDateTime deadline;
}
