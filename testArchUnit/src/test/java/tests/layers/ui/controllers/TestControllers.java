package tests.layers.ui.controllers;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import specials.MethodHasAtLeastOneParameter;
import specials.MethodHasExactlyOneParameter;
import thirdpartydependencies.ui.*;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestControllers {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.ui.controllers");

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().haveSimpleNameEndingWith("Controller")
                .andShould().beAnnotatedWith(RestController.class)
                .andShould().beAnnotatedWith(Tag.class)
                .check(classes);
    }

    @Test
    public void testAllMethods() {
        methods()
                .should().bePublic()
                .andShould().beAnnotatedWith(Operation.class)
                .check(classes);
    }

    @Test
    public void testGetMethods() {
        methods().that().areAnnotatedWith(GetMapping.class)
                .should().haveNameStartingWith("get")
                .check(classes);
    }

    @Test
    public void testDeleteMethods() {
        methods().that().areAnnotatedWith(DeleteMapping.class)
                .should().haveNameStartingWith("delete")
                .andShould().haveRawReturnType(void.class)
                .andShould(new MethodHasExactlyOneParameter(Integer.class))
                .check(classes);
    }

    @Test
    public void testPutMethods() {
        methods().that().areAnnotatedWith(PutMapping.class)
                .should().haveNameStartingWith("add")
                .andShould().haveRawReturnType(void.class)
                .andShould(new MethodHasAtLeastOneParameter())
                .check(classes);
    }

}
