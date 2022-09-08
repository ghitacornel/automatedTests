package architecture.layers.exception;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ExceptionLocationConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void location() {
        classes().that().areAssignableTo(Exception.class)
                .or().haveSimpleNameEndingWith("Exception")
                .should().resideInAPackage(Packages.EXCEPTION)
                .check(classes);
    }

}
