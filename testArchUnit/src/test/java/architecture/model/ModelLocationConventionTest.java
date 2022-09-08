package architecture.model;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ModelLocationConventionTest {

    private final JavaClasses classes = Packages.allClasses;

    @Test
    public void location() {
        classes().that().haveSimpleNameEndingWith("Dto")
                .or().haveSimpleNameEndingWith("DTO")
                .or().haveSimpleNameEndingWith("Request")
                .or().haveSimpleNameEndingWith("Response")
                .or().haveSimpleNameEndingWith("Json")
                .or().haveSimpleNameEndingWith("JSON")
                .or().haveSimpleNameEndingWith("Xml")
                .or().haveSimpleNameEndingWith("Xml")
                .or().haveSimpleNameEndingWith("Message")
                .or().haveSimpleNameEndingWith("Event")
                .should().resideInAPackage(Packages.MODEL)
                .check(classes);
    }

}
