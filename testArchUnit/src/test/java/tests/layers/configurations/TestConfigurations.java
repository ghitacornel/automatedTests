package tests.layers.configurations;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.configurations.Bean;
import thirdpartydependencies.configurations.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestConfigurations {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.configurations");

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().beAnnotatedWith(Configuration.class)
                .andShould().haveSimpleNameEndingWith("Configuration")
                .check(classes);
    }

    @Test
    public void testMethods() {
        methods().that().areAnnotatedWith(Bean.class)
                .should().bePublic()
                .check(classes);
    }
}
