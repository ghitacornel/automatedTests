package junit.rules.classes;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CustomClassRule implements TestRule {

    final private String marker;

    public CustomClassRule(String marker) {
        this.marker = marker;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                if (marker.equals("proceed")) {
                    base.evaluate();
                }
            }
        };
    }
}
