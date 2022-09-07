package specials.conditions;

import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

public class MethodHasExactlyOneParameter extends ArchCondition<JavaMethod> {

    private Class<?> clazz;

    public MethodHasExactlyOneParameter() {
        super("have exactly 1 parameter");
    }

    public MethodHasExactlyOneParameter(Class<?> clazz) {
        super("have exactly 1 parameter of type " + clazz);
        if (clazz == null) throw new IllegalArgumentException("null class parameter specified");
        this.clazz = clazz;
    }

    @Override
    public void check(JavaMethod item, ConditionEvents events) {
        if (item.getRawParameterTypes().size() != 1)
            events.add(new SimpleConditionEvent(null, false, "expected exactly 1 parameter"));
        if (!item.getRawParameterTypes().get(0).isAssignableTo(clazz))
            events.add(new SimpleConditionEvent(null, false, "expected exactly 1 parameter of type " + clazz));
    }
}
