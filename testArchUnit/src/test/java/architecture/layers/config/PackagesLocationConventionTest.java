package architecture.layers.config;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class PackagesLocationConventionTest {

    private final JavaClasses classes = Packages.allClasses;

    @Test
    public void location() {
        classes().that().areAnnotatedWith(Configuration.class)
                .or().haveSimpleNameEndingWith("Config")
                .or().haveSimpleNameEndingWith("Configuration")
                .should().resideInAPackage(Packages.CONFIG)
                .check(classes);
    }

}
