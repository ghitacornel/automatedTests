package tests.enforcement;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.*;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class TestLayersEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages("layers");

    @Test
    public void testNamingConventionsByPackageName() {

        classes().that().resideInAPackage("..controllers..")
                .should().haveSimpleNameEndingWith("Controller")
                .check(classes);
        classes().that().resideInAPackage("..jsons..")
                .should().haveSimpleNameEndingWith("Json")
                .check(classes);
        classes().that().resideInAPackage("..mappers..")
                .should().haveSimpleNameEndingWith("Mapper")
                .check(classes);

        classes().that()
                .resideInAPackage("..services")
                .and().areNotAnnotatedWith(Component.class)
                .and().areNotAnnotatedWith(UtilityMarker.class)
                .should().haveSimpleNameEndingWith("Service")
                .check(classes);

        classes().that().resideInAPackage("..repositories..")
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);
        classes().that().resideInAPackage("..listeners..")
                .should().haveSimpleNameEndingWith("Listener")
                .check(classes);

        classes().that().resideInAPackage("..configurations..")
                .should().haveSimpleNameEndingWith("Configuration")
                .check(classes);

    }

    @Test
    public void testNamingConventionsByAnnotation() {
        classes().that().areAnnotatedWith(RestController.class)
                .should().haveSimpleNameEndingWith("Controller")
                .check(classes);
        classes().that().areAnnotatedWith(Service.class)
                .should().haveSimpleNameEndingWith("Service")
                .check(classes);
        classes().that().areAnnotatedWith(Repository.class)
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);

        noClasses().that().areAnnotatedWith(Component.class)
                .should().haveSimpleNameEndingWith("Controller")
                .andShould().haveSimpleNameEndingWith("Service")
                .andShould().haveSimpleNameEndingWith("Repository")
                .check(classes);
    }

    @Test
    public void testClassLayerAccess() {

        noClasses().that().resideInAPackage("..daos..")
                .should().accessClassesThat().resideInAPackage("..ui..").check(classes);
        noClasses().that().resideInAPackage("..daos..")
                .should().accessClassesThat().resideInAPackage("..services..").check(classes);

        noClasses().that().resideInAPackage("..services..")
                .should().accessClassesThat().resideInAPackage("..ui..").check(classes);

        noClasses().that().resideInAPackage("..controllers..")
                .should().accessClassesThat().resideInAPackage("..daos..").check(classes);
    }

    @Test
    public void testClassSameLayerAccess() {

        {
            noClasses().that().resideInAPackage("..repositories..")
                    .should().accessClassesThat().resideInAPackage("..repositories..").check(classes);
            noClasses().that().resideInAPackage("..entities..")
                    .should().accessClassesThat().resideInAPackage("..repositories..").check(classes);

            noClasses().that().resideInAPackage("..listeners..")
                    .should().accessClassesThat().resideInAPackage("..repositories..").check(classes);
            classes().that().resideInAPackage("..listeners..")
                    .should().onlyBeAccessed().byClassesThat().resideInAPackage("..entities..");
        }

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
    public void testForbiddenUsage() {
        noClasses().should().dependOnClassesThat().resideInAPackage("java.lang.reflect..").check(classes);
    }

    @Test
    public void layer_dependencies_are_respected() {
        layeredArchitecture()
                .layer("Controllers").definedBy("layers.ui..")
                .layer("Services").definedBy("layers.services..")
                .layer("Persistence").definedBy("layers.daos..")
                .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
                .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers", "Services")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services")
                .check(classes);
    }

    @Test
    public void services_should_not_access_controllers() {
        noClasses().that().resideInAPackage("..services..")
                .should().accessClassesThat().resideInAPackage("..controllers..").check(classes);
    }

    @Test
    public void persistence_should_not_access_services() {
        noClasses().that().resideInAPackage("..daos..")
                .should().accessClassesThat().resideInAPackage("..services..").check(classes);
    }

    @Test
    public void services_should_only_be_accessed_by_controllers_or_other_services() {
        classes().that().resideInAPackage("..services..")
                .should().onlyBeAccessed().byAnyPackage("..controllers..", "..services..").check(classes);
    }

    @Test
    public void services_should_only_access_persistence_or_other_services() {
        classes().that().resideInAPackage("..services..")
                .should().onlyAccessClassesThat().resideInAnyPackage("..services..", "..daos..", "java..").check(classes);
    }

    // 'dependOn' catches a wider variety of violations, e.g. having fields of type, having method parameters of type, extending type ...

    @Test
    public void services_should_not_depend_on_controllers() {
        noClasses().that().resideInAPackage("..services..")
                .should().dependOnClassesThat().resideInAPackage("..controllers..").check(classes);
    }

    @Test
    public void persistence_should_not_depend_on_services() {
        noClasses().that().resideInAPackage("..daos..")
                .should().dependOnClassesThat().resideInAPackage("..services..").check(classes);
    }

    @Test
    public void services_should_only_be_depended_on_by_controllers_or_other_services() {
        classes().that().resideInAPackage("..services..")
                .should().onlyHaveDependentClassesThat().resideInAnyPackage("..controllers..", "..services..").check(classes);
    }

    @Test
    public void services_should_only_depend_on_persistence_or_other_services() {
        classes().that().resideInAPackage("..services..")
                .should().onlyDependOnClassesThat().resideInAnyPackage("..services..", "..daos..", "java..", "javax..", "thirdpartydependencies..")
                .check(classes);
    }

}
