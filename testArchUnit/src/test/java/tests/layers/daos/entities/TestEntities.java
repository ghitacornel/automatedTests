package tests.layers.daos.entities;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import specials.ClassHasOnePublicNoArgumentsConstructor;
import thirdpartydependencies.Entity;
import thirdpartydependencies.MappedSuperclass;
import thirdpartydependencies.Table;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestEntities {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.daos.entities");

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().beAnnotatedWith(Entity.class)
                .orShould().beAnnotatedWith(MappedSuperclass.class)
                .check(classes);
        classes().that().areAnnotatedWith(Entity.class)
                .should().beAnnotatedWith(Table.class)
                .andShould(new ClassHasOnePublicNoArgumentsConstructor())
                .check(classes);
        classes().that().areAnnotatedWith(MappedSuperclass.class)
                .should().haveModifier(JavaModifier.ABSTRACT)
                .check(classes);
    }

}