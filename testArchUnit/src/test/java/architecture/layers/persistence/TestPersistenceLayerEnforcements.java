package architecture.layers.persistence;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.Converter;
import thirdpartydependencies.Entity;
import thirdpartydependencies.MappedSuperclass;
import thirdpartydependencies.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestPersistenceLayerEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages(Packages.PERSISTENCE);

    @Test
    public void testNamingConventionsByPackageName() {

        classes().that().resideInAPackage(Packages.PERSISTENCE_REPOSITORIES)
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);

        classes().that().resideInAPackage(Packages.PERSISTENCE_LISTENERS)
                .should().haveSimpleNameEndingWith("Listener")
                .check(classes);

        classes().that().resideInAPackage(Packages.PERSISTENCE_CONVERTERS)
                .should().haveSimpleNameEndingWith("Converter")
                .check(classes);

    }

    @Test
    public void testNamingConventionsByAnnotation() {

        classes().that().areAnnotatedWith(Repository.class)
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);

        classes().that().areAnnotatedWith(Converter.class)
                .should().haveSimpleNameEndingWith("Converter")
                .check(classes);
    }

    @Test
    public void testClassSameLayerAccess() {

        noClasses().that().resideInAPackage(Packages.PERSISTENCE_REPOSITORIES)
                .should().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_REPOSITORIES)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_CONVERTERS)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_LISTENERS)
                .check(classes);

        noClasses().that().areAnnotatedWith(Entity.class).or().areAnnotatedWith(MappedSuperclass.class)
                .should().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_REPOSITORIES)
                .check(classes);

        noClasses().that().resideInAPackage(Packages.PERSISTENCE_LISTENERS)
                .should().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_LISTENERS)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_CONVERTERS)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_REPOSITORIES)
                .check(classes);

        noClasses().that().resideInAPackage(Packages.PERSISTENCE_CONVERTERS)
                .or().areAnnotatedWith(Converter.class)
                .should().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_LISTENERS)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_CONVERTERS)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_REPOSITORIES)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_ENTITIES)
                .orShould().dependOnClassesThat().areAnnotatedWith(Entity.class)
                .orShould().dependOnClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);

        classes().that().resideInAPackage(Packages.PERSISTENCE_LISTENERS)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Entity.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);

        classes().that().areAnnotatedWith(Converter.class)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Entity.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);

    }

}
