package architecture.misc;

import architecture.Packages;
import architecture.specials.ClassIsHelperClass;
import architecture.specials.ClassIsUtilityClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestHelperUtilityComponentClasses {

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

    }
}
