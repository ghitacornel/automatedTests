package architecture.layers.exception;

import architecture.Config;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ExceptionNamingConventionTest {

    private final JavaClasses classes = Config.allClassesWithoutTests;

    @Test
    public void basedOnPackage() {
        classes().that().resideInAPackage(Config.EXCEPTION)
                .should().haveSimpleNameEndingWith("Exception")
                .check(classes);
    }

    @Test
    public void basedOnType() {
        classes().that().areAssignableTo(Exception.class)
                .should().haveSimpleNameEndingWith("Exception")
                .check(classes);
    }

}
