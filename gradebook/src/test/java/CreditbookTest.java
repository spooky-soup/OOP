import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditbookTest {

    private Creditbook initCreditbook(int group, String name, String faculty, int diplomaGrade) {
        return new Creditbook(group, name, faculty, diplomaGrade);
    }

    private void addAllMarks(Creditbook credits, int semesterNumber, String[] subjects, int[] grades) {
        for (int i = 0; i < subjects.length; i++) {
            credits.addMark(semesterNumber, subjects[i], grades[i]);
        }
    }

    @Test
    public void MyTest() {
        String[] subjectsFirstSecond = {"Math analysis", "Declarative programming", "Digital platforms", "Discrete math", "Imperative programming"};
        int [][] marksInSemesters = {{5, 5, 5, 5, 4}, {4, 4, 5, 5, 4}};

        Creditbook myGrades = initCreditbook(20213, "D. Y. Kolomnikova", "FIT", 0);
        addAllMarks(myGrades, 1, subjectsFirstSecond, marksInSemesters[0]);
        addAllMarks(myGrades, 2, subjectsFirstSecond, marksInSemesters[1]);

        //check scholarship after 2nd semester
        boolean scholar = MarksUtils.hasHighScholarship(myGrades, 2);
        Assertions.assertTrue(scholar);

        //check if it is possible to have a red diploma
        myGrades.setQualificationWorkMark(5);
        boolean reddiploma = MarksUtils.isRedDiploma(myGrades);
        Assertions.assertFalse(reddiploma);

        //check average grade point
        double calcAverage = MarksUtils.average(myGrades);
        double realAverage = 4.6;
        Assertions.assertEquals(calcAverage, realAverage);
    }

    @Test
    public void notHighAverageTest()
    {
        String[] subjectsFirstSecond = {"Math analysis", "Declarative programming", "Digital platforms", "Discrete math", "Imperative programming"};
        int [][] marksInSemesters = {{3, 4, 5, 3, 4}, {4, 4, 4, 4, 3}};
        Creditbook notHighGrades = initCreditbook(20202, "I. I. Ivanov", "FIT", 0);
        addAllMarks(notHighGrades, 1, subjectsFirstSecond, marksInSemesters[0]);
        addAllMarks(notHighGrades, 2, subjectsFirstSecond, marksInSemesters[1]);

        //check scholarship after 2nd semester
        boolean scholar = MarksUtils.hasHighScholarship(notHighGrades, 2);
        Assertions.assertFalse(scholar);
    }

    @Test
    public void withRedDiploma()
    {
        String[] subjectsFirstSecond = {"Math analysis", "Declarative programming", "Digital platforms", "Discrete math", "Imperative programming"};
        int [][] marksInSemesters = {{5, 4, 5, 5, 5}, {5, 5, 5, 5, 4}};
        Creditbook redDiplomaGrades = initCreditbook(20202, "I. I. Ivanov", "FIT", 5);
        addAllMarks(redDiplomaGrades, 1, subjectsFirstSecond, marksInSemesters[0]);
        addAllMarks(redDiplomaGrades, 2, subjectsFirstSecond, marksInSemesters[1]);

        //check if it is possible to have a red diploma
        Assertions.assertTrue(MarksUtils.isRedDiploma(redDiplomaGrades));
    }
}
