package architecture.controller;

import architecture.Packages;
import architecture.specials.conditions.MethodHasAtLeastOneParameter;
import architecture.specials.conditions.MethodHasExactlyOneParameter;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;
import thirdpartydependencies.*;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class ControllerSpecificTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Packages.CONTROLLER);

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().beTopLevelClasses()
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
                .andShould(new MethodHasExactlyOneParameter())
                .check(classes);
    }

}
