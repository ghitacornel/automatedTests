package specials.conditions;

import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

public class MethodHasAtLeastOneParameter extends ArchCondition<JavaMethod> {

    public MethodHasAtLeastOneParameter() {
        super("have at least 1 parameter");
    }

    @Override
    public void check(JavaMethod item, ConditionEvents events) {
        if (item.getRawParameterTypes().isEmpty())
            events.add(new SimpleConditionEvent(null, false, "expected at least 1 parameter"));
    }
}
