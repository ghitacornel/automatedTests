package tests.layers.daos.listeners;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import layers.daos.entities.EntityTemplate;
import org.junit.Test;
import specials.MethodHasExactlyOneParameter;
import specials.ClassHasOnePublicNoArgumentsConstructor;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestListeners {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.daos.listeners");

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().haveSimpleNameEndingWith("Listener")
                .andShould(new ClassHasOnePublicNoArgumentsConstructor())
                .check(classes);
    }

    @Test
    public void testMethods() {
        methods()
                .should().haveRawReturnType(void.class)
                .andShould(new MethodHasExactlyOneParameter(EntityTemplate.class))
                .check(classes);
    }

}
