package specials;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaConstructor;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.util.Optional;

public class ClassHasExactlyOnePublicNoArgumentsConstructor extends ArchCondition<JavaClass> {

    public ClassHasExactlyOnePublicNoArgumentsConstructor() {
        super("have exactly 1 public no argument constructor");
    }

    @Override
    public void check(JavaClass item, ConditionEvents events) {
        if (item.getConstructors().size() != 1)
            events.add(new SimpleConditionEvent(null, false, "expected exactly 1 constructor"));

        Optional<JavaConstructor> constructor = item.getConstructors()
                .stream()
                .filter(JavaConstructor::isConstructor)
                .filter(o -> o.getModifiers().contains(JavaModifier.PUBLIC))
                .filter(o -> o.getRawParameterTypes().isEmpty())
                .findFirst();

        if (constructor.isEmpty())
            events.add(new SimpleConditionEvent(null, false, "expected 1 public no argument constructor"));
    }
}
