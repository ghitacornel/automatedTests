package tests.layers.rest;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.rest.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestRESTLayerEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages("ui");

    @Test
    public void testNamingConventionsByPackageName() {

        classes().that().resideInAPackage("..jsons..")
                .should().haveSimpleNameEndingWith("Json")
                .check(classes);

        classes().that().resideInAPackage("..mappers..")
                .should().haveSimpleNameEndingWith("Mapper")
                .check(classes);

        classes().that().resideInAPackage("..controllers..")
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

        noClasses().that().resideInAPackage("..jsons..")
                .should().dependOnClassesThat().resideInAPackage("..controllers..")
                .check(classes);
        noClasses().that().resideInAPackage("..jsons..")
                .should().dependOnClassesThat().resideInAPackage("..mappers..")
                .check(classes);

        noClasses().that().resideInAPackage("..mappers..")
                .should().dependOnClassesThat().resideInAPackage("..controllers..")
                .check(classes);
        noClasses().that().resideInAPackage("..mappers..")
                .should().dependOnClassesThat().areAnnotatedWith(RestController.class)
                .check(classes);

        noClasses().that().resideInAPackage("..controllers..")
                .should().dependOnClassesThat().resideInAPackage("..controllers..")
                .check(classes);
        noClasses().that().areAnnotatedWith(RestController.class)
                .should().dependOnClassesThat().areAnnotatedWith(RestController.class)
                .check(classes);

    }

}
