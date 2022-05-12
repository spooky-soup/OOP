import org.junit.jupiter.api.Test;
import ru.nsu.fit.pizzeria.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleTest {
    @Test
    void test() {
        BlockingQueue<Integer> orders = new LinkedBlockingQueue<Integer>();
        BlockingQueue<Integer> storage = new LinkedBlockingQueue<Integer>();
        Pizzeria pizzeria = new Pizzeria(orders, storage, 1, 1);
        pizzeria.run();
    }
}
