package tests.enforcement;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.business.components.Component;
import thirdpartydependencies.business.Utility;
import thirdpartydependencies.business.services.Service;
import thirdpartydependencies.configurations.Configuration;
import thirdpartydependencies.daos.repositories.Repository;
import thirdpartydependencies.ui.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class TestLayersEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages("layers");

    @Test
    public void testNamingConventionsByPackageName() {

        classes().that().resideInAPackage("..configurations..")
                .should().haveSimpleNameEndingWith("Configuration")
                .check(classes);

    }

    @Test
    public void testNamingConventionsByAnnotation() {

        classes().that().areAnnotatedWith(Configuration.class)
                .should().haveSimpleNameEndingWith("Configuration")
                .check(classes);
        classes().that().areAnnotatedWith(RestController.class)
                .should().haveSimpleNameEndingWith("Controller")
                .check(classes);
        classes().that().areAnnotatedWith(Service.class)
                .should().haveSimpleNameEndingWith("Service")
                .check(classes);
        classes().that().areAnnotatedWith(Repository.class)
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);

        classes().that().areAnnotatedWith(Component.class)
                .should().haveSimpleNameEndingWith("Component")
                .check(classes);
    }

    @Test
    public void testClassLayerAccess() {

        noClasses().that().resideInAPackage("..daos..")
                .should().accessClassesThat().resideInAPackage("..ui..").check(classes);
        noClasses().that().resideInAPackage("..daos..")
                .should().accessClassesThat().resideInAPackage("..business..").check(classes);

        noClasses().that().resideInAPackage("..business..")
                .should().accessClassesThat().resideInAPackage("..ui..").check(classes);

        noClasses().that().resideInAPackage("..controllers..")
                .should().accessClassesThat().resideInAPackage("..daos..").check(classes);
    }

    @Test
    public void testClassSameLayerAccess() {

        {
            noClasses().that().resideInAPackage("..controllers..")
                    .should().accessClassesThat().resideInAPackage("..controllers..").check(classes);

            noClasses().that().resideInAPackage("..jsons..")
                    .should().accessClassesThat().resideInAPackage("..mappers..").check(classes);
            noClasses().that().resideInAPackage("..jsons..")
                    .should().accessClassesThat().resideInAPackage("..controllers..").check(classes);
        }
    }

    @Test
    public void layer_dependencies_are_respected() {
        layeredArchitecture()
                .layer("Controllers").definedBy("layers.ui..")
                .layer("Business").definedBy("layers.business..")
                .layer("Persistence").definedBy("layers.daos..")
                .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
                .whereLayer("Business").mayOnlyBeAccessedByLayers("Controllers", "Business")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Business")
                .check(classes);
    }

    @Test
    public void services_should_not_access_controllers() {
        noClasses().that().resideInAPackage("..business..")
                .should().accessClassesThat().resideInAPackage("..controllers..").check(classes);
    }

    @Test
    public void persistence_should_not_access_services() {
        noClasses().that().resideInAPackage("..daos..")
                .should().accessClassesThat().resideInAPackage("..business..").check(classes);
    }

    @Test
    public void services_should_only_be_accessed_by_controllers_or_other_services() {
        classes().that().resideInAPackage("..business..")
                .should().onlyBeAccessed().byAnyPackage("..controllers..", "..business..").check(classes);
    }

    @Test
    public void services_should_only_access_persistence_or_other_services() {
        classes().that().resideInAPackage("..business..")
                .should().onlyAccessClassesThat().resideInAnyPackage("..business..", "..daos..", "java..").check(classes);
    }

    // 'dependOn' catches a wider variety of violations, e.g. having fields of type, having method parameters of type, extending type ...

    @Test
    public void services_should_not_depend_on_controllers() {
        noClasses().that().resideInAPackage("..business..")
                .should().dependOnClassesThat().resideInAPackage("..controllers..").check(classes);
    }

    @Test
    public void persistence_should_not_depend_on_services() {
        noClasses().that().resideInAPackage("..daos..")
                .should().dependOnClassesThat().resideInAPackage("..business..").check(classes);
    }

    @Test
    public void services_should_only_be_depended_on_by_controllers_or_other_services() {
        classes().that().resideInAPackage("..business..")
                .should().onlyHaveDependentClassesThat().resideInAnyPackage("..controllers..", "..business..").check(classes);
    }

    @Test
    public void services_should_only_depend_on_persistence_or_other_services() {
        classes().that().resideInAPackage("..business..")
                .should().onlyDependOnClassesThat().resideInAnyPackage("..business..", "..daos..", "java..", "javax..", "thirdpartydependencies..")
                .check(classes);
    }

}
