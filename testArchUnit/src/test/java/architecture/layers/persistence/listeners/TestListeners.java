package architecture.layers.persistence.listeners;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import layers.persistence.entities.EntityTemplate;
import org.junit.Test;
import architecture.specials.conditions.ClassHasExactlyOnePublicNoArgumentsConstructor;
import architecture.specials.conditions.MethodHasExactlyOneParameter;
import thirdpartydependencies.daos.listeners.*;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestListeners {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.PERSISTENCE_LISTENERS);

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
