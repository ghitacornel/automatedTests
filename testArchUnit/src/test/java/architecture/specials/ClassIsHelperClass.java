package architecture.specials;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaConstructor;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import thirdpartydependencies.business.Utility;

public class ClassIsHelperClass extends ArchCondition<JavaClass> {

    public ClassIsHelperClass() {
        super("is helper class");
    }

    @Override
    public void check(JavaClass item, ConditionEvents events) {

        if (!item.getName().endsWith("Helper")) {
            events.add(new SimpleConditionEvent(null, false, "helper class name does not end in Helper"));
        }

        if (!item.isAnnotatedWith(Utility.class)) {
            events.add(new SimpleConditionEvent(null, false, "helper class not annotated with @Utility"));
        }

        if (!item.getModifiers().contains(JavaModifier.FINAL)) {
            events.add(new SimpleConditionEvent(null, false, "helper class is not final"));
        }

        if (!item.isTopLevelClass()) {
            events.add(new SimpleConditionEvent(null, false, "helper class is not top level class"));
        }

        if (!item.isTopLevelClass()) {
            events.add(new SimpleConditionEvent(null, false, "helper class is not top level class"));
        }

        if (item.getConstructors()
                .stream()
                .filter(JavaConstructor::isConstructor)
                .filter(o -> o.getModifiers().contains(JavaModifier.PRIVATE))
                .filter(o -> o.getRawParameterTypes().isEmpty())
                .findAny()
                .isEmpty()) {
            events.add(new SimpleConditionEvent(null, false, "expected exactly 1 private no argument constructor"));
        }

        item.getFields().stream()
                .filter(o -> !o.getModifiers().contains(JavaModifier.STATIC))
                .filter(o -> o.getModifiers().contains(JavaModifier.FINAL))
                .findAny()
                .ifPresent(javaField -> events.add(new SimpleConditionEvent(null, false, "found non static non final field " + javaField.getFullName())));

        item.getMethods().stream()
                .filter(o -> !o.getModifiers().contains(JavaModifier.STATIC))
                .findAny()
                .ifPresent(javaMethod -> events.add(new SimpleConditionEvent(null, false, "found non static method " + javaMethod.getFullName())));
    }
}
