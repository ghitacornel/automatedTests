package architecture.persistence.listener;

import architecture.Packages;
import architecture.persistence.entity.EntityTemplate;
import architecture.specials.conditions.ClassHasExactlyOnePublicNoArgumentsConstructor;
import architecture.specials.conditions.MethodHasExactlyOneParameter;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;
import thirdpartydependencies.*;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class ListenerSpecificTest {

    private final JavaClasses classes = new ClassFileImporter().withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS).importPackages(Packages.PERSISTENCE_LISTENER);

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().beTopLevelClasses()
                .andShould().haveSimpleNameEndingWith("Listener")
                .andShould(new ClassHasExactlyOnePublicNoArgumentsConstructor())
                .check(classes);
    }

    @Test
    public void testMethods() {
        methods().that().areAnnotatedWith(PrePersist.class)
                .should().haveRawReturnType(void.class)
                .andShould(new MethodHasExactlyOneParameter(EntityTemplate.class))
                .check(classes);
        methods().that().areAnnotatedWith(PostPersist.class)
                .should().haveRawReturnType(void.class)
                .andShould(new MethodHasExactlyOneParameter(EntityTemplate.class))
                .check(classes);
        methods().that().areAnnotatedWith(PreUpdate.class)
                .should().haveRawReturnType(void.class)
                .andShould(new MethodHasExactlyOneParameter(EntityTemplate.class))
                .check(classes);
        methods().that().areAnnotatedWith(PostUpdate.class)
                .should().haveRawReturnType(void.class)
                .andShould(new MethodHasExactlyOneParameter(EntityTemplate.class))
                .check(classes);
        methods().that().areAnnotatedWith(PreRemove.class)
                .should().haveRawReturnType(void.class)
                .andShould(new MethodHasExactlyOneParameter(EntityTemplate.class))
                .check(classes);
        methods().that().areAnnotatedWith(PostRemove.class)
                .should().haveRawReturnType(void.class)
                .andShould(new MethodHasExactlyOneParameter(EntityTemplate.class))
                .check(classes);
        methods().that().areAnnotatedWith(PostLoad.class)
                .should().haveRawReturnType(void.class)
                .andShould(new MethodHasExactlyOneParameter(EntityTemplate.class))
                .check(classes);
    }

}
