import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Marks {
    public static double Average(Creditbook creditbook) {
        Collection<Integer> marks = creditbook.getAllMarks();
        double res = 0.0;
        for (int m : marks) {
            res += m;
        }
        res /= marks.size();
        return res;
    }

    public static boolean RedDiploma(Creditbook creditbook) {
        Collection<Integer> marks = creditbook.getAllMarks();
        long as = 0;
        as = marks.stream().filter(m -> m == 5).count();
        double percentage = (double)as / marks.size();
        boolean cmarks = marks.stream().anyMatch(m -> m < 4);

        return !cmarks && percentage >= 0.75 && creditbook.getQualificationWorkMark() == 5;
    }

    public static boolean scholarship(Creditbook creditbook, int semester) {
        Collection<Integer> marks = creditbook.getSemesterMarks(semester);
        boolean has_scholarship = true;
        for (int m : marks) {
            if (m < 4) {
                has_scholarship = false;
                break;
            }
        }
        return has_scholarship;
    }
}
