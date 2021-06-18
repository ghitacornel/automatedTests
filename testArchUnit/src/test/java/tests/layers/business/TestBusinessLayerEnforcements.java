package tests.layers.business;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import layers.Config;
import org.junit.Test;
import thirdpartydependencies.business.components.Component;
import thirdpartydependencies.business.services.Service;
import thirdpartydependencies.business.Utility;
import thirdpartydependencies.configurations.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestBusinessLayerEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.BUSINESS);

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

        noClasses().that().resideInAPackage(Config.MODEL)
                .should().dependOnClassesThat().areAnnotatedWith(Service.class)
                .orShould().dependOnClassesThat().areAnnotatedWith(Configuration.class)
                .check(classes);

        noClasses().that().resideInAPackage(Config.CONFIGURATION)
                .or().areAnnotatedWith(Configuration.class)
                .should().dependOnClassesThat().resideInAPackage(Config.SERVICES)
                .orShould().dependOnClassesThat().resideInAPackage(Config.COMPONENTS)
                .check(classes);

        noClasses().that().resideInAPackage(Config.CONFIGURATION)
                .should().onlyBeAccessed().byClassesThat().resideInAPackage(Config.SERVICES)
                .orShould().onlyBeAccessed().byClassesThat().resideInAPackage(Config.COMPONENTS)
                .check(classes);

        classes().that().areAnnotatedWith(Component.class)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Component.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(Utility.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(Service.class);

    }

}
