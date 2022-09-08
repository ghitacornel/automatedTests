package architecture.controller;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.Operation;
import thirdpartydependencies.RestController;
import thirdpartydependencies.Tag;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class ControllerDocumentationTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Packages.CONTROLLER);

    @Test
    public void testClasses() {
        classes().that().areAnnotatedWith(RestController.class)
                .should().beAnnotatedWith(Tag.class)
                .check(classes);
    }

    @Test
    public void testMethods() {
        methods().that().areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
                .should().beAnnotatedWith(Operation.class)
                .check(classes);
    }

}
