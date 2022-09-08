package architecture.controller.handler;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class HandlerAccessEnforcementConventionTest {

    private final JavaClasses classes = Packages.allClasses;

    @Test
    public void deny() {
        noClasses().that().resideInAPackage(Packages.HANDLER)
                .should().dependOnClassesThat().resideInAPackage(Packages.CONTROLLER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE)
                // TODO
                .check(classes);
    }

}
