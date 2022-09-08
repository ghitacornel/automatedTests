package architecture.controller;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestRESTLayerEnforcements {

    JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void testNamingConventionsByPackageName() {
        classes().that().resideInAPackage(Packages.CONTROLLER)
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

        noClasses().that().resideInAPackage(Packages.CONTROLLER)
                .or().areAnnotatedWith(RestController.class)
                .should().dependOnClassesThat().resideInAPackage(Packages.CONTROLLER)
                .orShould().dependOnClassesThat().areAnnotatedWith(RestController.class)
                .check(classes);

    }

}
