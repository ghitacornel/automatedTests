package architecture.layers.service;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import architecture.specials.ClassIsUtilityClass;
import thirdpartydependencies.Component;
import thirdpartydependencies.Service;
import thirdpartydependencies.Utility;
import thirdpartydependencies.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestUtilities {

    JavaClasses classes = new ClassFileImporter().importPackages(Packages.SERVICE);

    @Test
    public void testClasses() {
        classes().that()
                .areAnnotatedWith(Utility.class)
                .should(new ClassIsUtilityClass())
                .andShould().notBeAnnotatedWith(Service.class)
                .andShould().notBeAnnotatedWith(Component.class)
                .andShould().notBeAnnotatedWith(Configuration.class)
                .check(classes);
    }

}
