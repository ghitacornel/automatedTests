package architecture.controller.handler;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.ControllerAdvice;
import thirdpartydependencies.ControllerAdviceInterface;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class HandlerLocationConventionTest {

    private final JavaClasses classes = Packages.allClasses;

    @Test
    public void location() {
        classes().that().areAnnotatedWith(ControllerAdvice.class)
                .or().implement(ControllerAdviceInterface.class)
                .or().haveSimpleNameEndingWith("ControllerAdvice")
                .should().resideInAPackage(Packages.HANDLER)
                .check(classes);
    }

}
