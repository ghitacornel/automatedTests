package architecture.layers.misc;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;
import thirdpartydependencies.business.services.Service;
import thirdpartydependencies.business.services.Transactional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestTransactional {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.ROOT);

    @Test
    public void testClasses() {
        classes().that().areAnnotatedWith(Transactional.class)
                .should().beAnnotatedWith(Service.class)
                .check(classes);
    }

    @Test
    public void testMethods() {
        methods().that().areAnnotatedWith(Transactional.class)
                .should().bePublic()
                .andShould().beDeclaredInClassesThat().areAnnotatedWith(Service.class)
                .check(classes);
    }

}
