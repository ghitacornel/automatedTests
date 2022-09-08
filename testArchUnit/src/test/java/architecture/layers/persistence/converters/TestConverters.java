package architecture.layers.persistence.converters;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;
import architecture.specials.conditions.ClassHasOnePublicNoArgumentsConstructor;
import thirdpartydependencies.daos.converters.AttributeConverter;
import thirdpartydependencies.daos.converters.Converter;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestConverters {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.PERSISTENCE_CONVERTERS);

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().beTopLevelClasses()
                .andShould().beAnnotatedWith(Converter.class)
                .andShould().implement(AttributeConverter.class)
                .andShould().haveSimpleNameEndingWith("Converter")
                .andShould(new ClassHasOnePublicNoArgumentsConstructor())
                .check(classes);
    }

}
