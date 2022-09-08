package architecture.layers.exception;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ExceptionAccessEnforcementConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void deny() {
        noClasses().that().resideInAPackage(Packages.EXCEPTION)
                .should().dependOnClassesThat().resideInAPackage(Packages.BUSINESS)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.BUSINESS_CONFIGURATION)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.EXCEPTION)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.REST_CONTROLLERS)
                // TODO
                .check(classes);
    }

}
