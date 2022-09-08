package architecture.enforcement;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.Component;
import thirdpartydependencies.Repository;
import thirdpartydependencies.RestController;
import thirdpartydependencies.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class NamingConfigurationTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Packages.ROOT);

    @Test
    public void testNamingConventionsByAnnotation() {

        classes().that().areAnnotatedWith(Service.class)
                .should().haveSimpleNameEndingWith("Service")
                .check(classes);
        classes().that().areAnnotatedWith(Repository.class)
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);
        classes().that().areAnnotatedWith(Component.class)
                .should().haveSimpleNameEndingWith("Component")
                .check(classes);
    }

}
