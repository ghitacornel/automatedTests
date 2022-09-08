package architecture.service;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ServiceNamingConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void basedOnPackage() {
        classes().that().resideInAPackage(Packages.SERVICE)
                .should().haveSimpleNameEndingWith("Service")
                .orShould().haveSimpleNameEndingWith("ServiceImpl")
                .orShould().haveSimpleNameEndingWith("Helper")
                .orShould().haveSimpleNameEndingWith("Utility")
                .orShould().haveSimpleNameEndingWith("Utils")
                .orShould().haveSimpleNameEndingWith("Component")
                .check(classes);
    }

    @Test
    public void basedOnAnnotation() {
        classes().that().areAnnotatedWith(Service.class)
                .should().haveSimpleNameEndingWith("Service")
                .orShould().haveSimpleNameEndingWith("ServiceImpl")
                .check(classes);
    }

}
