package architecture.persistence.listener;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ListenerLocationConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void location() {
        classes().that().haveSimpleNameEndingWith("Listener")
                .or().haveSimpleNameEndingWith("EntityListener")
                .should().resideInAPackage(Packages.PERSISTENCE_LISTENER)
                .check(classes);
    }

}
