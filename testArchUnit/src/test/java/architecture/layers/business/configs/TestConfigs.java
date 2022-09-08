package architecture.layers.business.configs;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;
import thirdpartydependencies.configurations.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestConfigs {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.BUSINESS_CONFIGURATION);

    @Test
    public void testClasses() {
        classes().that()
                .areAnnotatedWith(Configuration.class)
                .should().bePublic()
                .andShould().beTopLevelClasses()
                .andShould().haveSimpleNameEndingWith("Configuration")
                .check(classes);
    }

    @Test
    public void testMethods() {

    }

}
