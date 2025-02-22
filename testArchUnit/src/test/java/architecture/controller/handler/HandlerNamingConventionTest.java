package architecture.controller.handler;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.Test;
import thirdpartydependencies.ControllerAdvice;
import thirdpartydependencies.ControllerAdviceInterface;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class HandlerNamingConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void basedOnPackage() {
        classes().that().resideInAPackage(Packages.CONTROLLER_ADVICE)
                .should().haveSimpleNameEndingWith("ControllerAdvice")
                .check(classes);
    }

    @Test
    public void basedOnAnnotation() {
        classes().that().areAnnotatedWith(ControllerAdvice.class)
                .or().implement(ControllerAdviceInterface.class)
                .should().haveSimpleNameEndingWith("ControllerAdvice")
                .check(classes);
    }

}
