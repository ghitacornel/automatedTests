package specials;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaConstructor;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import thirdpartydependencies.business.Utility;

import java.util.Optional;

public class ClassIsUtilityClass extends ArchCondition<JavaClass> {

    public ClassIsUtilityClass() {
        super("is utility class");
    }

    @Override
    public void check(JavaClass item, ConditionEvents events) {

        if (!item.isAnnotatedWith(Utility.class)) {
            events.add(new SimpleConditionEvent(null, false, "utility class not annotated with @Utility"));
        }

        if (!item.getModifiers().contains(JavaModifier.FINAL)) {
            events.add(new SimpleConditionEvent(null, false, "utility class is not final"));
        }

        Optional<JavaConstructor> constructor = item.getConstructors()
                .stream()
                .filter(JavaConstructor::isConstructor)
                .filter(o -> o.getModifiers().contains(JavaModifier.PRIVATE))
                .filter(o -> o.getRawParameterTypes().isEmpty())
                .findFirst();
        if (constructor.isEmpty())
            events.add(new SimpleConditionEvent(null, false, "expected 1 private no argument constructor"));

        item.getFields().stream()
                .filter(o -> !o.getModifiers().contains(JavaModifier.STATIC))
                .filter(o -> o.getModifiers().contains(JavaModifier.FINAL))
                .findFirst()
                .ifPresent(javaField -> events.add(new SimpleConditionEvent(null, false, "found non static non final field " + javaField.getFullName())));

        item.getMethods().stream()
                .filter(o -> !o.getModifiers().contains(JavaModifier.STATIC))
                .findFirst()
                .ifPresent(javaMethod -> events.add(new SimpleConditionEvent(null, false, "found non static method " + javaMethod.getFullName())));
    }
}
