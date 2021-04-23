package junit.rules.methods;

import org.junit.Rule;
import org.junit.Test;

public class TestMethodRuleGo {

    @Rule
    public CustomMethodRule rule = new CustomMethodRule("proceed");

    @Test
    public void testGo() {
        System.out.println("GO");
    }
}
