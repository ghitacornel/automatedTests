package junit.rules.classes;

import org.junit.ClassRule;
import org.junit.Test;

public class TestClassRuleNoGo {

    @ClassRule
    public static CustomClassRule rule = new CustomClassRule("do not proceed");

    @Test
    public void testGo() {
        System.out.println("GO");
    }
}
