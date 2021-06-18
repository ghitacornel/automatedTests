package tests.layers.business.configs;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import layers.Config;
import org.junit.Test;
import thirdpartydependencies.business.components.Component;
import thirdpartydependencies.business.services.Transactional;
import thirdpartydependencies.configurations.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noMethods;

public class TestConfigs {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.CONFIGURATION);

    @Test
    public void testClasses() {
        classes().that()
                .areAnnotatedWith(Configuration.class)
                .should().bePublic()
                .andShould().haveSimpleNameEndingWith("Configuration")
                .check(classes);
    }

    @Test
    public void testMethods() {

    }

}
