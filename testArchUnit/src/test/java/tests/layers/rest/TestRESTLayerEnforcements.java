package tests.layers.rest;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import layers.Config;
import org.junit.Test;
import thirdpartydependencies.rest.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestRESTLayerEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.REST);

    @Test
    public void testNamingConventionsByPackageName() {

        classes().that().resideInAPackage(Config.REST_JSONS)
                .should().haveSimpleNameEndingWith("Json")
                .check(classes);

        classes().that().resideInAPackage(Config.MAPPERS)
                .should().haveSimpleNameEndingWith("Mapper")
                .check(classes);

        classes().that().resideInAPackage(Config.REST_CONTROLLERS)
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

        noClasses().that().resideInAPackage(Config.REST_JSONS)
                .should().dependOnClassesThat().resideInAPackage(Config.REST_CONTROLLERS)
                .orShould().dependOnClassesThat().resideInAPackage(Config.MAPPERS)
                .check(classes);

        noClasses().that().resideInAPackage(Config.MAPPERS)
                .should().dependOnClassesThat().resideInAPackage(Config.REST_CONTROLLERS)
                .orShould().dependOnClassesThat().areAnnotatedWith(RestController.class)
                .check(classes);

        noClasses().that().resideInAPackage(Config.REST_CONTROLLERS)
                .or().areAnnotatedWith(RestController.class)
                .should().dependOnClassesThat().resideInAPackage(Config.REST_CONTROLLERS)
                .orShould().dependOnClassesThat().areAnnotatedWith(RestController.class)
                .check(classes);

    }

}
