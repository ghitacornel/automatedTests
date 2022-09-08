package architecture.layers.persistence.converter;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import architecture.specials.conditions.ClassHasOnePublicNoArgumentsConstructor;
import thirdpartydependencies.AttributeConverter;
import thirdpartydependencies.Converter;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ConverterSpecificTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Packages.PERSISTENCE_CONVERTER);

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().beTopLevelClasses()
                .andShould().beAnnotatedWith(Converter.class)
                .andShould().implement(AttributeConverter.class)
                .andShould(new ClassHasOnePublicNoArgumentsConstructor())
                .check(classes);
    }

}
