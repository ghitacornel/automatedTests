package architecture.enforcement;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class LayersAccessTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Config.ROOT);

    @Test
    public void testClassLayerAccess() {

        noClasses().that().resideInAPackage(Config.PERSISTENCE)
                .should().accessClassesThat().resideInAPackage(Config.REST).check(classes);
        noClasses().that().resideInAPackage(Config.PERSISTENCE)
                .should().accessClassesThat().resideInAPackage(Config.BUSINESS).check(classes);

        noClasses().that().resideInAPackage(Config.BUSINESS)
                .should().accessClassesThat().resideInAPackage(Config.REST).check(classes);

        noClasses().that().resideInAPackage(Config.BUSINESS)
                .should().accessClassesThat().resideInAPackage(Config.PERSISTENCE).check(classes);
    }

    @Test
    public void layer_dependencies_are_respected() {
        layeredArchitecture()
                .layer("Rest").definedBy(Config.REST + "..")
                .layer("Business").definedBy(Config.BUSINESS + "..")
                .layer("Persistence").definedBy(Config.PERSISTENCE + "..")
                .whereLayer("Rest").mayNotBeAccessedByAnyLayer()
                .whereLayer("Business").mayOnlyBeAccessedByLayers("Rest", "Business")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Business")
                .check(classes);
    }

    @Test
    public void services_should_not_access_controllers() {
        noClasses().that().resideInAPackage(Config.BUSINESS)
                .should().accessClassesThat().resideInAPackage(Config.REST_CONTROLLERS).check(classes);
    }

    @Test
    public void persistence_should_not_access_services() {
        noClasses().that().resideInAPackage(Config.PERSISTENCE)
                .should().accessClassesThat().resideInAPackage(Config.BUSINESS).check(classes);
    }

    @Test
    public void services_should_only_be_accessed_by_controllers_or_other_services() {
        classes().that().resideInAPackage(Config.BUSINESS)
                .should().onlyBeAccessed().byAnyPackage(Config.REST_CONTROLLERS, Config.BUSINESS).check(classes);
    }

    @Test
    public void services_should_only_access_persistence_or_other_services() {
        classes().that().resideInAPackage(Config.BUSINESS)
                .should().onlyAccessClassesThat().resideInAnyPackage(Config.BUSINESS, Config.PERSISTENCE, "java..").check(classes);
    }

    // 'dependOn' catches a wider variety of violations, e.g. having fields of type, having method parameters of type, extending type ...

    @Test
    public void services_should_not_depend_on_controllers() {
        noClasses().that().resideInAPackage(Config.BUSINESS)
                .should().dependOnClassesThat().resideInAPackage(Config.REST_CONTROLLERS).check(classes);
    }

    @Test
    public void persistence_should_not_depend_on_services() {
        noClasses().that().resideInAPackage(Config.PERSISTENCE)
                .should().dependOnClassesThat().resideInAPackage(Config.BUSINESS).check(classes);
    }

    @Test
    public void services_should_only_be_depended_on_by_controllers_or_other_services() {
        classes().that().resideInAPackage(Config.BUSINESS)
                .should().onlyHaveDependentClassesThat().resideInAnyPackage(Config.REST_CONTROLLERS, Config.BUSINESS).check(classes);
    }

    @Test
    public void services_should_only_depend_on_persistence_or_other_services() {
        classes().that().resideInAPackage(Config.BUSINESS)
                .should().onlyDependOnClassesThat().resideInAnyPackage(Config.BUSINESS, Config.PERSISTENCE, "java..", "javax..", "thirdpartydependencies..")
                .check(classes);
    }

}
