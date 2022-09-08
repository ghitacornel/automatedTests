package architecture.layers.business;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.Component;
import thirdpartydependencies.Service;
import thirdpartydependencies.Utility;
import thirdpartydependencies.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestBusinessLayerEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages(Packages.BUSINESS);

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
                .or().resideInAPackage(Packages.BUSINESS_JSON)
                .should().dependOnClassesThat().areAnnotatedWith(Service.class)
                .orShould().dependOnClassesThat().areAnnotatedWith(Configuration.class)
                .orShould().dependOnClassesThat().areAnnotatedWith(Component.class)
                .orShould().dependOnClassesThat().areAnnotatedWith(Utility.class)
                .check(classes);

        noClasses().that().resideInAPackage(Packages.BUSINESS_CONFIGURATION)
                .or().areAnnotatedWith(Configuration.class)
                .should().dependOnClassesThat().resideInAPackage(Packages.BUSINESS_SERVICES)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.BUSINESS_COMPONENTS)
                .check(classes);

        classes().that().resideInAPackage(Packages.BUSINESS_CONFIGURATION)
                .should().onlyBeAccessed().byClassesThat().resideInAPackage(Packages.BUSINESS_SERVICES)
                .orShould().onlyBeAccessed().byClassesThat().resideInAPackage(Packages.BUSINESS_COMPONENTS)
                .check(classes);

        classes().that().areAnnotatedWith(Component.class)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Component.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(Service.class);

    }

}
