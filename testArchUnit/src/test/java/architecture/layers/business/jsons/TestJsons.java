package architecture.layers.business.jsons;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestJsons {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.BUSINESS_JSON);

    @Test
    public void testClasses() {
        classes()
                .should().bePublic()
                .andShould().haveSimpleNameEndingWith("Json")
                .check(classes);
    }

}
