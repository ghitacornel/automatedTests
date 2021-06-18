package tests.enforcement;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.business.services.Service;
import thirdpartydependencies.business.services.Transactional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

public class TestForbiddenUsage {

    JavaClasses classes = new ClassFileImporter().importPackages("layers");

    @Test
    public void testReflection() {
        noClasses().should().dependOnClassesThat().resideInAPackage("java.lang.reflect..")
                .check(classes);
    }

    @Test
    public void testThreadLocal() {
        noClasses().should().dependOnClassesThat().areAssignableTo(ThreadLocal.class)
                .check(classes);
    }

    @Test
    public void testTransactional() {
        noMethods()
                .that().areDeclaredInClassesThat().areNotAnnotatedWith(Service.class)
                .should().beAnnotatedWith(Transactional.class)
                .check(classes);
        classes()
                .that().areAnnotatedWith(Transactional.class)
                .should().beAnnotatedWith(Service.class)
                .check(classes);
    }
}
