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

        classes().that().resideInAPackage(Packages.PERSISTENCE_REPOSITORY)
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);

        classes().that().resideInAPackage(Packages.PERSISTENCE_LISTENER)
                .should().haveSimpleNameEndingWith("Listener")
                .check(classes);

        classes().that().resideInAPackage(Packages.PERSISTENCE_CONVERTER)
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

        noClasses().that().resideInAPackage(Packages.PERSISTENCE_REPOSITORY)
                .should().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_REPOSITORY)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_CONVERTER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_LISTENER)
                .check(classes);

        noClasses().that().areAnnotatedWith(Entity.class).or().areAnnotatedWith(MappedSuperclass.class)
                .should().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_REPOSITORY)
                .check(classes);

        noClasses().that().resideInAPackage(Packages.PERSISTENCE_LISTENER)
                .should().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_LISTENER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_CONVERTER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_REPOSITORY)
                .check(classes);

        noClasses().that().resideInAPackage(Packages.PERSISTENCE_CONVERTER)
                .or().areAnnotatedWith(Converter.class)
                .should().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_LISTENER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_CONVERTER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_REPOSITORY)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_ENTITY)
                .orShould().dependOnClassesThat().areAnnotatedWith(Entity.class)
                .orShould().dependOnClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);

        classes().that().resideInAPackage(Packages.PERSISTENCE_LISTENER)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Entity.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);

        classes().that().areAnnotatedWith(Converter.class)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Entity.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);

    }

}
