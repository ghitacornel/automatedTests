package architecture.layers.persistence.entities;

import architecture.persistence.entities.EntityTemplate;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;
import architecture.specials.conditions.ClassHasOnePublicNoArgumentsConstructor;
import thirdpartydependencies.daos.entities.Entity;
import thirdpartydependencies.daos.entities.MappedSuperclass;
import thirdpartydependencies.daos.entities.Table;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestEntities {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.PERSISTENCE_ENTITIES);

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .check(classes);

        classes()
                .should().beAnnotatedWith(Entity.class)
                .orShould().beAnnotatedWith(MappedSuperclass.class)
                .check(classes);

        classes().that().areAnnotatedWith(Entity.class)
                .should().beAnnotatedWith(Table.class)
                .check(classes);
        classes().that().areAnnotatedWith(Table.class)
                .should().beAnnotatedWith(Entity.class)
                .check(classes);

        classes().that().areAnnotatedWith(Entity.class)
                .should(new ClassHasOnePublicNoArgumentsConstructor())
                .andShould().beTopLevelClasses()
                .andShould().beAssignableTo(EntityTemplate.class)
                .check(classes);

        classes().that().areAnnotatedWith(MappedSuperclass.class)
                .should().haveModifier(JavaModifier.ABSTRACT)
                .andShould().beTopLevelClasses()
                .check(classes);
    }

}
