import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class Parser extends Operations{
    Map<String, Object>parseOp = new HashMap<String, Object>(){{
       put("+", new Object());
    }};

    parseOp.put("+", new add());
}
