package architecture.controller.handler;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.Test;
import thirdpartydependencies.ControllerAdvice;
import thirdpartydependencies.ControllerAdviceInterface;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class HandlerSpecificTest {

    private final JavaClasses classes = new ClassFileImporter().withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS).importPackages(Packages.CONTROLLER_ADVICE);

    @Test
    public void testClasses() {
        classes().should().beTopLevelClasses()
                .andShould().beAnnotatedWith(ControllerAdvice.class)
                .andShould().implement(ControllerAdviceInterface.class)
                .check(classes);
    }

}
