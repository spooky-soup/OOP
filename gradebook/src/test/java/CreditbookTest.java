
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CreditbookTest {
    @Test
    public void MyTest() {
        Creditbook mygrades = new Creditbook(20213, "D. Y. Kolomnikova", "FIT", 0);
        mygrades.addMark(1, "Math analysis", 5);
        mygrades.addMark(1, "Declarative programming", 5);
        mygrades.addMark(1, "Digital platforms", 5);
        mygrades.addMark(1, "Discrete math", 5);
        mygrades.addMark(1, "Imperative programming", 4);
        mygrades.addMark(2, "Math analysis", 4);
        mygrades.addMark(2, "Declarative programming", 4);
        mygrades.addMark(2, "Imperative programming", 4);
        mygrades.addMark(2, "Digital platforms", 5);
        mygrades.addMark(2, "Discrete math", 5);

        //check scholarship after 2nd semester
        boolean scholar = Marks.scholarship(mygrades, 2);
        Assert.assertEquals(scholar, true);

        //check if it is possible to have a red diploma
        mygrades.setQualificationWorkMark(5);
        boolean reddiploma = Marks.RedDiploma(mygrades);
        Assert.assertEquals(reddiploma, false);
    }
}
