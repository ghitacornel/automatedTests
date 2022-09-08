package architecture.layers.exception;

import architecture.Config;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ExceptionLocationConventionTest {

    private final JavaClasses classes = Config.allClassesWithoutTests;

    @Test
    public void location() {
        classes().that().areAssignableTo(Exception.class)
                .or().haveSimpleNameEndingWith("Exception")
                .should().resideInAPackage(Config.EXCEPTION)
                .check(classes);
    }

}
