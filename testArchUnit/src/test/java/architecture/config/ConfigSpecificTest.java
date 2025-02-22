package architecture.config;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;
import thirdpartydependencies.Bean;
import thirdpartydependencies.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class ConfigSpecificTest {

    private final JavaClasses classes = new ClassFileImporter().withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS).importPackages(Packages.CONFIG);

    @Test
    public void specificClass() {
        classes().that().areAnnotatedWith(Configuration.class)
                .should().beTopLevelClasses()
                .check(classes);
    }

    @Test
    public void specificMethod() {
        methods().that().areAnnotatedWith(Bean.class)
                .should().beDeclaredInClassesThat().areAnnotatedWith(Configuration.class)
                .check(classes);
    }

}
