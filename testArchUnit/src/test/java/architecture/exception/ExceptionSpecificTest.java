package architecture.exception;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ExceptionSpecificTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Packages.EXCEPTION);

    @Test
    public void specific() {
        classes().that().areAssignableTo(Exception.class)
                .should().bePublic()
                .andShould().beTopLevelClasses()
                .check(classes);
        classes().that().haveSimpleNameEndingWith("Exception")
                .should().beAssignableTo(Exception.class)
                .check(classes);
    }

}
