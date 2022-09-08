package architecture.layers.business.components;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.Component;
import thirdpartydependencies.Transactional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

public class TestComponents {

    JavaClasses classes = new ClassFileImporter().importPackages(Packages.BUSINESS_COMPONENTS);

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