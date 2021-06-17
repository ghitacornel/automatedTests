package tests.enforcement;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.services.Component;
import thirdpartydependencies.services.Service;
import thirdpartydependencies.services.UtilityMarker;
import thirdpartydependencies.ui.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class TestForbiddenUsage {

    JavaClasses classes = new ClassFileImporter().importPackages("layers");

    @Test
    public void testReflection() {
        noClasses().should().dependOnClassesThat().resideInAPackage("java.lang.reflect..").check(classes);
    }

    @Test
    public void testThreadLocal() {
        noClasses().should().dependOnClassesThat().areAssignableTo(ThreadLocal.class).check(classes);
    }

}
