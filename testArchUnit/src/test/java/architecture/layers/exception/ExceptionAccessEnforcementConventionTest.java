package architecture.layers.exception;

import architecture.Config;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ExceptionAccessEnforcementConventionTest {

    private final JavaClasses classes = Config.allClassesWithoutTests;

    @Test
    public void deny() {
        noClasses().that().resideInAPackage(Config.EXCEPTION)
                .should().dependOnClassesThat().resideInAPackage(Config.BUSINESS)
                .orShould().dependOnClassesThat().resideInAPackage(Config.BUSINESS_CONFIGURATION)
                .orShould().dependOnClassesThat().resideInAPackage(Config.EXCEPTION)
                .orShould().dependOnClassesThat().resideInAPackage(Config.REST_CONTROLLERS)
                // TODO
                .check(classes);
    }

}
