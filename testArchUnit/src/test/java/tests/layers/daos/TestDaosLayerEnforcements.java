package tests.layers.daos;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import layers.Config;
import org.junit.Test;
import thirdpartydependencies.daos.converters.Converter;
import thirdpartydependencies.daos.entities.Entity;
import thirdpartydependencies.daos.entities.MappedSuperclass;
import thirdpartydependencies.daos.repositories.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class TestDaosLayerEnforcements {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.persistence);

    @Test
    public void testNamingConventionsByPackageName() {

        classes().that().resideInAPackage(Config.repositories)
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);

        classes().that().resideInAPackage(Config.listeners)
                .should().haveSimpleNameEndingWith("Listener")
                .check(classes);

        classes().that().resideInAPackage(Config.converters)
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

        noClasses().that().resideInAPackage(Config.repositories)
                .should().dependOnClassesThat().resideInAPackage(Config.repositories)
                .check(classes);
        noClasses().that().resideInAPackage(Config.repositories)
                .should().dependOnClassesThat().resideInAPackage(Config.converters)
                .check(classes);
        noClasses().that().resideInAPackage(Config.repositories)
                .should().dependOnClassesThat().resideInAPackage(Config.listeners)
                .check(classes);

        noClasses().that().areAnnotatedWith(Entity.class)
                .should().dependOnClassesThat().resideInAPackage(Config.repositories)
                .check(classes);
        noClasses().that().areAnnotatedWith(MappedSuperclass.class)
                .should().dependOnClassesThat().resideInAPackage(Config.repositories)
                .check(classes);

        noClasses().that().resideInAPackage(Config.listeners)
                .should().dependOnClassesThat().resideInAPackage(Config.listeners)
                .check(classes);
        noClasses().that().resideInAPackage(Config.listeners)
                .should().dependOnClassesThat().resideInAPackage(Config.converters)
                .check(classes);
        noClasses().that().resideInAPackage(Config.listeners)
                .should().dependOnClassesThat().resideInAPackage(Config.repositories)
                .check(classes);

        noClasses().that().areAnnotatedWith(Converter.class)
                .should().dependOnClassesThat().areAnnotatedWith(Entity.class)
                .check(classes);
        noClasses().that().areAnnotatedWith(Converter.class)
                .should().dependOnClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);

        classes().that().resideInAPackage(Config.listeners)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Entity.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);
        classes().that().areAnnotatedWith(Converter.class)
                .should().onlyBeAccessed().byClassesThat().areAnnotatedWith(Entity.class)
                .orShould().onlyBeAccessed().byClassesThat().areAnnotatedWith(MappedSuperclass.class)
                .check(classes);

    }

}
