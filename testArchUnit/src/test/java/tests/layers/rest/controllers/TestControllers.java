package tests.layers.rest.controllers;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import layers.Config;
import org.junit.Test;
import specials.MethodHasAtLeastOneParameter;
import specials.MethodHasExactlyOneParameter;
import thirdpartydependencies.rest.*;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestControllers {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.REST_CONTROLLERS);

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().haveSimpleNameEndingWith("Controller")
                .andShould().beAnnotatedWith(RestController.class)
                .check(classes);
    }

    @Test
    public void testAllMethods() {
        methods()
                .should().bePublic()
                .check(classes);
    }

    @Test
    public void testGetMethods() {
        methods().that().areAnnotatedWith(GetMapping.class)
                .should().haveNameStartingWith("get")
                .check(classes);
    }

    @Test
    public void testPostMethods() {
        methods().that().areAnnotatedWith(PostMapping.class)
                .should().haveNameStartingWith("post")
                .andShould().notHaveRawReturnType(void.class)
                .andShould().notHaveRawReturnType(Void.class)
                .andShould(new MethodHasAtLeastOneParameter())
                .check(classes);
    }

    @Test
    public void testPutMethods() {
        methods().that().areAnnotatedWith(PutMapping.class)
                .should().haveNameStartingWith("put")
                .andShould().haveRawReturnType(void.class)
                .andShould(new MethodHasAtLeastOneParameter())
                .check(classes);
    }

    @Test
    public void testPatchMethods() {
        methods().that().areAnnotatedWith(PatchMapping.class)
                .should().haveNameStartingWith("patch")
                .andShould().haveRawReturnType(void.class)
                .andShould(new MethodHasAtLeastOneParameter())
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

}
