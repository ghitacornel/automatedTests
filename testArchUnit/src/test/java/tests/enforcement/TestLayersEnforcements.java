package tests.enforcement;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.*;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

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
        noClasses().that().resideInAPackage("..repositories..")
                .should().accessClassesThat().resideInAPackage("..repositories..").check(classes);
        noClasses().that().resideInAPackage("..entities..")
                .should().accessClassesThat().resideInAPackage("..repositories..").check(classes);
        noClasses().that().resideInAPackage("..listeners..")
                .should().accessClassesThat().resideInAPackage("..repositories..").check(classes);
        noClasses().that().resideInAPackage("..daos..")
                .should().accessClassesThat().resideInAPackage("..ui..").check(classes);

        noClasses().that().resideInAPackage("..daos..")
                .should().accessClassesThat().resideInAPackage("..services..").check(classes);

        noClasses().that().resideInAPackage("..services..")
                .should().accessClassesThat().resideInAPackage("..ui..").check(classes);

        noClasses().that().resideInAPackage("..controllers..")
                .should().accessClassesThat().resideInAPackage("..controllers..").check(classes);
        noClasses().that().resideInAPackage("..jsons..")
                .should().accessClassesThat().resideInAPackage("..jsons..").check(classes);
        noClasses().that().resideInAPackage("..jsons..")
                .should().accessClassesThat().resideInAPackage("..controllers..").check(classes);
    }

}
