package junit.rules.classes;

import org.junit.ClassRule;
import org.junit.Test;

public class TestClassRuleGo {

    @ClassRule
    public static CustomClassRule rule = new CustomClassRule("proceed");

    @Test
    public void testGo() {
        System.out.println("GO");
    }
}
