package architecture.exception;

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
                .orShould().dependOnClassesThat().resideInAPackage(Packages.CONTROLLER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.CONTROLLER_ADVICE)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.MAPPER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE)
                // TODO
                .check(classes);
    }

}
