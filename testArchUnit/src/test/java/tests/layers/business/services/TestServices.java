package tests.layers.business.services;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.business.Component;
import thirdpartydependencies.business.Service;
import thirdpartydependencies.business.UtilityMarker;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestServices {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.services");

    @Test
    public void testClasses() {
        classes().that()
                .resideOutsideOfPackage("..model..")
                .and()
                .areNotAnnotatedWith(Component.class)
                .and()
                .areNotAnnotatedWith(UtilityMarker.class)
                .should().bePublic()
                .andShould().haveSimpleNameEndingWith("Service")
                .andShould().beAnnotatedWith(Service.class)
                .check(classes);
    }

}
