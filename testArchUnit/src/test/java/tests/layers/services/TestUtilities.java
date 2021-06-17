package tests.layers.services;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import specials.ClassIsUtilityClass;
import thirdpartydependencies.services.Component;
import thirdpartydependencies.services.Service;
import thirdpartydependencies.services.UtilityMarker;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestUtilities {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.services");

    @Test
    public void testClasses() {
        classes().that()
                .areAnnotatedWith(UtilityMarker.class)
                .should().haveSimpleNameEndingWith("Utils")
                .andShould().notBeAnnotatedWith(Service.class)
                .andShould().notBeAnnotatedWith(Component.class)
                .andShould(new ClassIsUtilityClass())
                .check(classes);
    }

}
