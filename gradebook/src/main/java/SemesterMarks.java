import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SemesterMarks {
    private final Map<String, Integer> semester = new HashMap<String, Integer>();

    SemesterMarks() {}

    protected void setGrade(String subject, int mark) {
        this.semester.put(subject, mark);
    }

    protected Collection<Integer> getMarks() {
        return this.semester.values();
    }

    protected Collection<String> getSubjects() {
        return this.semester.keySet();
    }
}
