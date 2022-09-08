package architecture.layers.misc;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;
import thirdpartydependencies.RestController;
import thirdpartydependencies.Operation;
import thirdpartydependencies.Tag;

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
    public void testMethods() {
        methods().that().areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
                .should().bePublic()
                .andShould().beAnnotatedWith(Operation.class)
                .check(classes);
    }

}
