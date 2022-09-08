package architecture.enforcement;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;
import thirdpartydependencies.Component;
import thirdpartydependencies.Service;
import thirdpartydependencies.Configuration;
import thirdpartydependencies.Repository;
import thirdpartydependencies.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class NamingConfigurationTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Config.ROOT);

    @Test
    public void testNamingConventionsByPackageName() {

        classes().that().resideInAPackage(Config.BUSINESS_CONFIGURATION)
                .should().haveSimpleNameEndingWith("Configuration")
                .check(classes);

    }

    @Test
    public void testNamingConventionsByAnnotation() {

        classes().that().areAnnotatedWith(Configuration.class)
                .should().haveSimpleNameEndingWith("Config")
                .orShould().haveSimpleNameEndingWith("Configuration")
                .check(classes);
        classes().that().areAnnotatedWith(RestController.class)
                .should().haveSimpleNameEndingWith("Controller")
                .orShould().haveSimpleNameEndingWith("RestController")
                .check(classes);
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
