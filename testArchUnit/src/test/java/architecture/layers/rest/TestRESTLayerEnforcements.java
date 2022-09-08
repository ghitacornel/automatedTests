package architecture.layers.rest;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestRESTLayerEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages(Packages.REST);

    @Test
    public void testNamingConventionsByPackageName() {
        classes().that().resideInAPackage(Packages.REST_CONTROLLERS)
                .should().haveSimpleNameEndingWith("Controller")
                .check(classes);
    }

    @Test
    public void testNamingConventionsByAnnotation() {

        classes().that().areAnnotatedWith(RestController.class)
                .should().haveSimpleNameEndingWith("Controller")
                .check(classes);

    }

    @Test
    public void testClassSameLayerAccess() {

        noClasses().that().resideInAPackage(Packages.REST_CONTROLLERS)
                .or().areAnnotatedWith(RestController.class)
                .should().dependOnClassesThat().resideInAPackage(Packages.REST_CONTROLLERS)
                .orShould().dependOnClassesThat().areAnnotatedWith(RestController.class)
                .check(classes);

    }

}
