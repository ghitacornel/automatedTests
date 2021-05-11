package tests.layers.ui.mappers;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestMappers {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.ui.mappers");

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().haveSimpleNameEndingWith("Mapper")
                .check(classes);
    }

}
