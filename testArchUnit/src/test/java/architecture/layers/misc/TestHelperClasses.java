package architecture.layers.misc;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;
import architecture.specials.ClassIsHelperClass;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestHelperClasses {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.ROOT);

    @Test
    public void testHelperClasses() {
        classes()
                .that().haveSimpleNameEndingWith("Helper")
                .should().notBePublic()
                .andShould(new ClassIsHelperClass())
                .check(classes);

    }
}
