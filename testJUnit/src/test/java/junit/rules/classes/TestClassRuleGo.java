package junit.rules.classes;

import org.junit.ClassRule;
import org.junit.Test;

public class TestClassRuleGo {

    @ClassRule
    public static CustomClassRule customClassRule = new CustomClassRule("proceed");

    @Test
    public void testGo() {
        System.out.println("GO");
    }
}
