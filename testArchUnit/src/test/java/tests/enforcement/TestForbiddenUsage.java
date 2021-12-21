package tests.enforcement;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import layers.Config;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestForbiddenUsage {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.ROOT);

    @Test
    public void testReflectionUsageIsForbidden() {
        noClasses().should().dependOnClassesThat().resideInAPackage("java.lang.reflect..")
                .check(classes);
    }

    @Test
    public void testThreadLocalUsageIsForbidden() {
        noClasses().should().dependOnClassesThat().areAssignableTo(ThreadLocal.class)
                .check(classes);
    }

}
