package architecture.enforcement;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class LayersAccessTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void testClassLayerAccess() {

        noClasses().that().resideInAPackage(Packages.PERSISTENCE)
                .should().accessClassesThat().resideInAPackage(Packages.CONTROLLER).check(classes);
        noClasses().that().resideInAPackage(Packages.PERSISTENCE)
                .should().accessClassesThat().resideInAPackage(Packages.BUSINESS).check(classes);

        noClasses().that().resideInAPackage(Packages.BUSINESS)
                .should().accessClassesThat().resideInAPackage(Packages.CONTROLLER).check(classes);

        noClasses().that().resideInAPackage(Packages.BUSINESS)
                .should().accessClassesThat().resideInAPackage(Packages.PERSISTENCE).check(classes);
    }

    @Test
    public void layer_dependencies_are_respected() {
        layeredArchitecture()
                .layer("Rest").definedBy(Packages.CONTROLLER + "..")
                .layer("Business").definedBy(Packages.BUSINESS + "..")
                .layer("Persistence").definedBy(Packages.PERSISTENCE + "..")
                .whereLayer("Rest").mayNotBeAccessedByAnyLayer()
                .whereLayer("Business").mayOnlyBeAccessedByLayers("Rest", "Business")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Business")
                .check(classes);
    }

    @Test
    public void services_should_not_access_controllers() {
        noClasses().that().resideInAPackage(Packages.BUSINESS)
                .should().accessClassesThat().resideInAPackage(Packages.CONTROLLER).check(classes);
    }

    @Test
    public void persistence_should_not_access_services() {
        noClasses().that().resideInAPackage(Packages.PERSISTENCE)
                .should().accessClassesThat().resideInAPackage(Packages.BUSINESS).check(classes);
    }

    @Test
    public void services_should_only_be_accessed_by_controllers_or_other_services() {
        classes().that().resideInAPackage(Packages.BUSINESS)
                .should().onlyBeAccessed().byAnyPackage(Packages.CONTROLLER, Packages.BUSINESS).check(classes);
    }

    @Test
    public void services_should_only_access_persistence_or_other_services() {
        classes().that().resideInAPackage(Packages.BUSINESS)
                .should().onlyAccessClassesThat().resideInAnyPackage(Packages.BUSINESS, Packages.PERSISTENCE, "java..").check(classes);
    }

    // 'dependOn' catches a wider variety of violations, e.g. having fields of type, having method parameters of type, extending type ...

    @Test
    public void services_should_not_depend_on_controllers() {
        noClasses().that().resideInAPackage(Packages.BUSINESS)
                .should().dependOnClassesThat().resideInAPackage(Packages.CONTROLLER).check(classes);
    }

    @Test
    public void persistence_should_not_depend_on_services() {
        noClasses().that().resideInAPackage(Packages.PERSISTENCE)
                .should().dependOnClassesThat().resideInAPackage(Packages.BUSINESS).check(classes);
    }

    @Test
    public void services_should_only_be_depended_on_by_controllers_or_other_services() {
        classes().that().resideInAPackage(Packages.BUSINESS)
                .should().onlyHaveDependentClassesThat().resideInAnyPackage(Packages.CONTROLLER, Packages.BUSINESS).check(classes);
    }

    @Test
    public void services_should_only_depend_on_persistence_or_other_services() {
        classes().that().resideInAPackage(Packages.BUSINESS)
                .should().onlyDependOnClassesThat().resideInAnyPackage(Packages.BUSINESS, Packages.PERSISTENCE, "java..", "javax..", "thirdpartydependencies..")
                .check(classes);
    }

}
