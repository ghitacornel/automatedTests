package tests.layers.business;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import specials.ClassIsUtilityClass;
import thirdpartydependencies.business.components.Component;
import thirdpartydependencies.business.services.Service;
import thirdpartydependencies.business.Utility;
import thirdpartydependencies.configurations.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestUtilities {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.services");

    @Test
    public void testClasses() {
        classes().that()
                .areAnnotatedWith(Utility.class)
                .should().haveSimpleNameEndingWith("Utils")
                .andShould().notBeAnnotatedWith(Service.class)
                .andShould().notBeAnnotatedWith(Component.class)
                .andShould().notBeAnnotatedWith(Configuration.class)
                .andShould(new ClassIsUtilityClass())
                .check(classes);
    }

}
