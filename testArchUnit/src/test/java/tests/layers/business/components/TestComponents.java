package tests.layers.business.components;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import layers.Config;
import org.junit.Test;
import thirdpartydependencies.business.components.Component;
import thirdpartydependencies.business.services.Transactional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

public class TestComponents {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.COMPONENTS);

    @Test
    public void testClasses() {
        classes().that().areAnnotatedWith(Component.class)
                .should().bePublic()
                .andShould().beTopLevelClasses()
                .andShould().haveSimpleNameEndingWith("Component")
                .check(classes);
    }

    @Test
    public void testMethods() {
        noMethods().should().beAnnotatedWith(Transactional.class)
                .check(classes);
    }

}
