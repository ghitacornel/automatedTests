package tests.layers.business;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.business.Component;
import thirdpartydependencies.business.services.Service;
import thirdpartydependencies.business.Utility;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestLayerEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages("daos");

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

    }

    @Test
    public void testClassSameLayerAccess() {

        noClasses().that().resideInAPackage("..model..")
                .should().accessClassesThat().resideInAPackage("..services..").check(classes);
        noClasses().that().resideInAPackage("..utility..")
                .should().accessClassesThat().resideInAPackage("..services..").check(classes);

        classes().that().resideInAPackage("..utility..")
                .should().onlyBeAccessed().byClassesThat().resideInAPackage("..services..");
        classes().that().areAnnotatedWith(Component.class)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Component.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(Utility.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(Service.class);

    }

}
