package architecture.persistence.converter;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.AttributeConverter;
import thirdpartydependencies.Converter;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ConvertersLocationConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void location() {
        classes().that().areAnnotatedWith(Converter.class)
                .or().implement(AttributeConverter.class)
                .or().haveSimpleNameEndingWith("Converter")
                .or().haveSimpleNameEndingWith("AttributeConverter")
                .should().resideInAPackage(Packages.PERSISTENCE_CONVERTER)
                .check(classes);
    }

}
