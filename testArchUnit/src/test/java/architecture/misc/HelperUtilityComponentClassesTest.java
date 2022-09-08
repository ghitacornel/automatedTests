package architecture.misc;

import architecture.Packages;
import architecture.specials.ClassIsHelperClass;
import architecture.specials.ClassIsUtilityClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.Component;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class HelperUtilityComponentClassesTest {

    private final JavaClasses classes = Packages.allClasses;

    @Test
    public void testHelperClasses() {
        classes()
                .that().haveSimpleNameEndingWith("Helper")
                .should().notBePublic()
                .andShould(new ClassIsHelperClass())
                .check(classes);
        classes().that().haveSimpleNameEndingWith("Utils")
                .or().haveSimpleNameEndingWith("Utility")
                .should().bePublic()
                .andShould(new ClassIsUtilityClass())
                .check(classes);

        classes().that().haveSimpleNameEndingWith("Component")
                .should().beAnnotatedWith(Component.class)
                .andShould().notBePublic()
                .check(classes);
        classes().that().areAnnotatedWith(Component.class)
                .should().haveSimpleNameEndingWith("Component")
                .andShould().notBePublic()
                .check(classes);

    }
}
