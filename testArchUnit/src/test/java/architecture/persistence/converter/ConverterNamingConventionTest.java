package architecture.persistence.converter;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.AttributeConverter;
import thirdpartydependencies.Converter;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ConverterNamingConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void basedOnPackage() {
        classes().that().resideInAPackage(Packages.PERSISTENCE_CONVERTER)
                .should().haveSimpleNameEndingWith("Converter")
                .orShould().haveSimpleNameEndingWith("AttributeConverter")
                .check(classes);
    }

    @Test
    public void basedOnAnnotation() {
        classes().that().areAnnotatedWith(Converter.class)
                .or().implement(AttributeConverter.class)
                .should().haveSimpleNameEndingWith("Converter")
                .orShould().haveSimpleNameEndingWith("AttributeConverter")
                .check(classes);
    }

}
