package architecture.layers.service;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.Component;
import thirdpartydependencies.Service;
import thirdpartydependencies.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestBusinessLayerEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages(Packages.SERVICE);

    @Test
    public void testNamingConventionsByPackageName() {
    }

    @Test
    public void testNamingConventionsByAnnotation() {
        classes().that().areAnnotatedWith(Service.class)
                .should().haveSimpleNameEndingWith("Service")
                .check(classes);
        classes().that().areAnnotatedWith(Component.class)
                .should().haveSimpleNameEndingWith("Component")
                .check(classes);
        classes().that().areAnnotatedWith(Configuration.class)
                .should().haveSimpleNameEndingWith("Configuration")
                .check(classes);
    }

    @Test
    public void testClassSameLayerAccess() {

        noClasses().that().resideInAPackage(Packages.BUSINESS_MODEL)
                .should().dependOnClassesThat().areAnnotatedWith(Service.class)
                .orShould().dependOnClassesThat().areAnnotatedWith(Configuration.class)
                .orShould().dependOnClassesThat().areAnnotatedWith(Component.class)
                .check(classes);


        classes().that().areAnnotatedWith(Component.class)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Component.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(Service.class);

    }

}
