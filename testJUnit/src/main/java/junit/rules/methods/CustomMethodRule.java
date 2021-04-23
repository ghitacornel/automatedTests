package junit.rules.methods;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CustomMethodRule implements TestRule {

    final private String marker;

    public CustomMethodRule(String marker) {
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
