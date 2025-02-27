package architecture.persistence.entity;

import architecture.Packages;
import architecture.specials.conditions.ClassHasOnePublicNoArgumentsConstructor;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;
import thirdpartydependencies.*;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

public class EntitySpecificTest {

    private final JavaClasses classes = new ClassFileImporter().withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS).importPackages(Packages.PERSISTENCE_ENTITY);

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
                .check(classes);

        classes().that().areAnnotatedWith(MappedSuperclass.class)
                .should().haveModifier(JavaModifier.ABSTRACT)
                .andShould().beTopLevelClasses()
                .andShould().haveSimpleNameEndingWith("Template")
                .check(classes);

        fields().that().areAnnotatedWith(OneToMany.class)
                .or().areAnnotatedWith(ManyToMany.class)
                .should().beFinal()
                .check(classes);
    }

}
