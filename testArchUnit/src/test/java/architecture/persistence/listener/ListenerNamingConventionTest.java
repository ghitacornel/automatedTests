package architecture.persistence.listener;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ListenerNamingConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void basedOnPackage() {
        classes().that().resideInAPackage(Packages.PERSISTENCE_LISTENER)
                .should().haveSimpleNameEndingWith("Listener")
                .orShould().haveSimpleNameEndingWith("EntityListener")
                .check(classes);
    }

}
