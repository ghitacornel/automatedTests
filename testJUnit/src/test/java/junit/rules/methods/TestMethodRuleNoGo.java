package junit.rules.methods;

import org.junit.Rule;
import org.junit.Test;

public class TestMethodRuleNoGo {

    @Rule
    public CustomMethodRule rule = new CustomMethodRule("do not proceed");

    @Test
    public void testGo() {
        System.out.println("GO");
    }
}
