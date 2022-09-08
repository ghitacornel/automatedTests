package architecture.mapper;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class MapperAccessEnforcementConventionTest {

    private final JavaClasses classes = Packages.allClasses;

    @Test
    public void deny() {
        noClasses().that().resideInAPackage(Packages.MAPPER)
                .should().dependOnClassesThat().resideInAPackage(Packages.CONTROLLER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.CONTROLLER_ADVICE)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.BUSINESS)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.BUSINESS_COMPONENTS)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.BUSINESS_CONFIGURATION)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_CONVERTER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_LISTENER)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_ENTITY)
                .orShould().dependOnClassesThat().resideInAPackage(Packages.PERSISTENCE_REPOSITORY)
                // TODO
                .check(classes);
    }

}
