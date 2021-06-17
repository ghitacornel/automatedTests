package tests.layers.daos.converters;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import specials.ClassHasOnePublicNoArgumentsConstructor;
import thirdpartydependencies.daos.converters.AttributeConverter;
import thirdpartydependencies.daos.converters.Converter;
import thirdpartydependencies.daos.entities.Entity;
import thirdpartydependencies.daos.entities.MappedSuperclass;
import thirdpartydependencies.daos.entities.Table;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestConverters {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.daos.converters");

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().beAnnotatedWith(Converter.class)
                .andShould().implement(AttributeConverter.class)
                .andShould().haveSimpleNameEndingWith("Converter")
                .andShould(new ClassHasOnePublicNoArgumentsConstructor())
                .check(classes);
    }

}
