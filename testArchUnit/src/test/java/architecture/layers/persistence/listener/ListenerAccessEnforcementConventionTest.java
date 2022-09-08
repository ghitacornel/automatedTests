package architecture.layers.persistence.listener;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ListenerAccessEnforcementConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void deny() {
        noClasses().that().resideInAPackage(Packages.PERSISTENCE_LISTENER)
                .should().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_CONVERTER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_LISTENER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_REPOSITORY)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.BUSINESS_SERVICES)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.CONTROLLER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.HANDLER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.MAPPER)
                .check(classes);
    }

}
