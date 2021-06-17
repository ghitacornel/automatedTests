package tests.layers.business;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import specials.ClassIsUtilityClass;
import thirdpartydependencies.business.Component;
import thirdpartydependencies.business.service.Service;
import thirdpartydependencies.business.Utility;

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
                .andShould(new ClassIsUtilityClass())
                .check(classes);
    }

}
