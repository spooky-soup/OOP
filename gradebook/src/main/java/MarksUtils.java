import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MarksUtils {
    public static double average(Creditbook creditbook) {
        Collection<Integer> marks = creditbook.getAllMarks();
        double res = 0.0;
        for (int m : marks) {
            res += m;
        }
        res /= marks.size();
        return res;
    }

    public static boolean isRedDiploma(Creditbook creditbook) {
        Collection<Integer> marks = creditbook.getAllMarks();
        long as = 0;
        as = marks.stream().filter(m -> m == 5).count();
        double percentage = (double)as / marks.size();
        boolean cmarks = marks.stream().anyMatch(m -> m < 4);

        return !cmarks && percentage >= 0.75 && creditbook.getQualificationWorkMark() == 5;
    }

    public static boolean hasHighScholarship(Creditbook creditbook, int semester) {
        Collection<Integer> marks = creditbook.getSemesterMarks(semester);
        boolean hasScholarship = true;
        for (int m : marks) {
            if (m < 4) {
                hasScholarship = false;
                break;
            }
        }
        return hasScholarship;
    }
}
