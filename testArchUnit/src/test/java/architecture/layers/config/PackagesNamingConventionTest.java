package architecture.layers.config;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class PackagesNamingConventionTest {

    private final JavaClasses classes = Packages.allClasses;

    @Test
    public void basedOnPackage() {
        classes().that().resideInAPackage(Packages.CONFIG)
                .should().haveSimpleNameEndingWith("Config")
                .orShould().haveSimpleNameEndingWith("Configuration")
                .check(classes);
    }

    @Test
    public void basedOnAnnotation() {
        classes().that().areAnnotatedWith(Configuration.class)
                .should().haveSimpleNameEndingWith("Config")
                .orShould().haveSimpleNameEndingWith("Configuration")
                .check(classes);
    }

}
