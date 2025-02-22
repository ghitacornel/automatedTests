package architecture.model;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ModelNamingConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void basedOnPackage() {
        classes().that().resideInAPackage(Packages.MODEL)
                .should().haveSimpleNameEndingWith("Dto")
                .orShould().haveSimpleNameEndingWith("DTO")
                .orShould().haveSimpleNameEndingWith("Request")
                .orShould().haveSimpleNameEndingWith("Response")
                .orShould().haveSimpleNameEndingWith("Json")
                .orShould().haveSimpleNameEndingWith("JSON")
                .orShould().haveSimpleNameEndingWith("Xml")
                .orShould().haveSimpleNameEndingWith("Xml")
                .orShould().haveSimpleNameEndingWith("Message")
                .orShould().haveSimpleNameEndingWith("Event")
                .check(classes);
    }

    @Test
    public void basedOnAnnotation() {
        // none
    }

}
