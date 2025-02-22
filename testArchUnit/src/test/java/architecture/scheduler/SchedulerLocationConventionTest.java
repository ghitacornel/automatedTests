package architecture.scheduler;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class SchedulerLocationConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void location() {
        classes().that().haveSimpleNameEndingWith("Scheduler")
                .should().resideInAPackage(Packages.SCHEDULER)
                .check(classes);
    }

}
