package architecture.controller;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ControllerAccessEnforcementConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void deny() {
        noClasses().that().resideInAPackage(Packages.CONTROLLER)
                .should().dependOnClassesThat().resideInAPackage(Packages.CONTROLLER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.MAPPER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.EXCEPTION)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE)
                // TODO
                .check(classes);
    }

}
