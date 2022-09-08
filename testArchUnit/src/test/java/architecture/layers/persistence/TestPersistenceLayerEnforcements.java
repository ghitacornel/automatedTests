package architecture.layers.persistence;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;
import thirdpartydependencies.Converter;
import thirdpartydependencies.Entity;
import thirdpartydependencies.MappedSuperclass;
import thirdpartydependencies.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestPersistenceLayerEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.PERSISTENCE);

    @Test
    public void testNamingConventionsByPackageName() {

        classes().that().resideInAPackage(Config.PERSISTENCE_REPOSITORIES)
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);

        classes().that().resideInAPackage(Config.PERSISTENCE_LISTENERS)
                .should().haveSimpleNameEndingWith("Listener")
                .check(classes);

        classes().that().resideInAPackage(Config.PERSISTENCE_CONVERTERS)
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

        noClasses().that().resideInAPackage(Config.PERSISTENCE_REPOSITORIES)
                .should().dependOnClassesThat().resideInAPackage(Config.PERSISTENCE_REPOSITORIES)
                .orShould().dependOnClassesThat().resideInAPackage(Config.PERSISTENCE_CONVERTERS)
                .orShould().dependOnClassesThat().resideInAPackage(Config.PERSISTENCE_LISTENERS)
                .check(classes);

        noClasses().that().areAnnotatedWith(Entity.class).or().areAnnotatedWith(MappedSuperclass.class)
                .should().dependOnClassesThat().resideInAPackage(Config.PERSISTENCE_REPOSITORIES)
                .check(classes);

        noClasses().that().resideInAPackage(Config.PERSISTENCE_LISTENERS)
                .should().dependOnClassesThat().resideInAPackage(Config.PERSISTENCE_LISTENERS)
                .orShould().dependOnClassesThat().resideInAPackage(Config.PERSISTENCE_CONVERTERS)
                .orShould().dependOnClassesThat().resideInAPackage(Config.PERSISTENCE_REPOSITORIES)
                .check(classes);

        noClasses().that().resideInAPackage(Config.PERSISTENCE_CONVERTERS)
                .or().areAnnotatedWith(Converter.class)
                .should().dependOnClassesThat().resideInAPackage(Config.PERSISTENCE_LISTENERS)
                .orShould().dependOnClassesThat().resideInAPackage(Config.PERSISTENCE_CONVERTERS)
                .orShould().dependOnClassesThat().resideInAPackage(Config.PERSISTENCE_REPOSITORIES)
                .orShould().dependOnClassesThat().resideInAPackage(Config.PERSISTENCE_ENTITIES)
                .orShould().dependOnClassesThat().areAnnotatedWith(Entity.class)
                .orShould().dependOnClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);

        classes().that().resideInAPackage(Config.PERSISTENCE_LISTENERS)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Entity.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);

        classes().that().areAnnotatedWith(Converter.class)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Entity.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);

    }

}
