package tests.layers.misc;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import layers.Config;
import org.junit.Test;
import thirdpartydependencies.configurations.Bean;
import thirdpartydependencies.configurations.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestConfigurations {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.ROOT);

    @Test
    public void testClasses() {
        classes().that().areAnnotatedWith(Configuration.class)
                .should().beTopLevelClasses()
                .andShould().haveSimpleNameEndingWith("Configuration")
                .check(classes);
    }

    @Test
    public void testMethods() {
        methods().that().areAnnotatedWith(Bean.class)
                .should().beDeclaredInClassesThat().areAnnotatedWith(Configuration.class)
                .check(classes);
    }

}
