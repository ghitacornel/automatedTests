package tests.layers.business.model;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;

import java.io.Serializable;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestModel {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.services.model");

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().implement(Serializable.class)
                .check(classes);
    }

}
