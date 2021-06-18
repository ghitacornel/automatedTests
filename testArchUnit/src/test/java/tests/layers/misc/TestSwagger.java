package tests.layers.misc;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import layers.Config;
import org.junit.Test;
import thirdpartydependencies.rest.RestController;
import thirdpartydependencies.rest.swagger.Operation;
import thirdpartydependencies.rest.swagger.Tag;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestSwagger {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.ROOT);

    @Test
    public void testClasses() {
        classes().that().areAnnotatedWith(RestController.class)
                .should().bePublic()
                .andShould().beTopLevelClasses()
                .andShould().beAnnotatedWith(Tag.class)
                .check(classes);
    }

    @Test
    public void testAllMethods() {
        methods().that().areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
                .should().bePublic()
                .andShould().beAnnotatedWith(Operation.class)
                .check(classes);
    }

}
