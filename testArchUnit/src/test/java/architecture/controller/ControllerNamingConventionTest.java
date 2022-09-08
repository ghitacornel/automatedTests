package architecture.controller;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.Controller;
import thirdpartydependencies.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ControllerNamingConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void basedOnPackage() {
        classes().that().resideInAPackage(Packages.CONTROLLER)
                .should().haveSimpleNameEndingWith("Controller")
                .orShould().haveSimpleNameEndingWith("RestController")
                .check(classes);
    }

    @Test
    public void basedOnAnnotation() {
        classes().that().areAnnotatedWith(Controller.class)
                .should().haveSimpleNameEndingWith("Controller")
                .check(classes);
        classes().that().areAnnotatedWith(RestController.class)
                .should().haveSimpleNameEndingWith("Controller")
                .orShould().haveSimpleNameEndingWith("RestController")
                .check(classes);
    }

}
