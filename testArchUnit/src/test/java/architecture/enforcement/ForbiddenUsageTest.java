package architecture.enforcement;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ForbiddenUsageTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void reflection() {
        noClasses().should().dependOnClassesThat().resideInAPackage("java.lang.reflect..")
                .check(classes);
    }

    @Test
    public void threadLocal() {
        noClasses().should().dependOnClassesThat().areAssignableTo(ThreadLocal.class)
                .check(classes);
    }

}
