package architecture.service;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.Test;
import thirdpartydependencies.Component;
import thirdpartydependencies.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ServicesSpecificTest {

    private final JavaClasses classes = new ClassFileImporter().withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS).importPackages(Packages.SERVICE);

    @Test
    public void testClasses() {
        classes().that().areAnnotatedWith(Service.class)
                .should().bePublic()
                .andShould().beTopLevelClasses()
                .check(classes);

        classes().that().areAnnotatedWith(Component.class)
                .should().beTopLevelClasses()
                .check(classes);
    }

}
