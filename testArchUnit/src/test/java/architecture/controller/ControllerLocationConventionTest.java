package architecture.controller;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.Controller;
import thirdpartydependencies.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ControllerLocationConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void location() {
        classes().that().areAnnotatedWith(Controller.class)
                .or().areAnnotatedWith(RestController.class)
                .or().haveSimpleNameEndingWith("Controller")
                .or().haveSimpleNameEndingWith("RestController")
                .should().resideInAPackage(Packages.CONTROLLER)
                .check(classes);
    }

}
