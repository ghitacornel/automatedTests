package architecture.enforcement;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ForbiddenUsageTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Config.ROOT);

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
