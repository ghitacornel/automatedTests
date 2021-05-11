package tests.layers.ui.jsons;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestJsons {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.ui.jsons");

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().haveSimpleNameEndingWith("Json")
                .check(classes);
    }

}
