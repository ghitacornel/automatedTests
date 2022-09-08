package architecture.layers.config;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.Bean;
import thirdpartydependencies.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class PackagesSpecificTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Packages.CONFIG);

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
