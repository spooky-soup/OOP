import java.util.ArrayList;
import java.util.Collection;

public class Creditbook extends SemesterMarks{
    private int group;
    private String faculty;
    private String name;
    private int diplomaGrade;
    private SemesterMarks[] semesters = new SemesterMarks[8];

    public Creditbook(int group, String name, String faculty, int diplomaGrade) {
        this.group = group;
        this.name = name;
        this.faculty = faculty;
        this.diplomaGrade = diplomaGrade;

        for(int i = 0; i < 8; i++) {
            semesters[i] = new SemesterMarks();
        }
    }

    public void addMark(int semester, String subject, int mark) {
        this.semesters[semester].setGrade(subject, mark);
    }

    public SemesterMarks[] getInfo() {
        return semesters;
    }

    public Collection<Integer> getSemesterMarks(int semesterNumber) {
        return semesters[semesterNumber - 1].getMarks();
    }

    public Collection<Integer> getAllMarks() {
        ArrayList<Integer> marks = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            marks.addAll(semesters[i].getMarks());
        }
        return marks;
    }

    public void setQualificationWorkMark(int mark) {
        this.diplomaGrade = mark;
    }

    public Integer getQualificationWorkMark() {
        return diplomaGrade;
    }


}
