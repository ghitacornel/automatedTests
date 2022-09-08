package architecture.persistence.listeners;

import architecture.persistence.entities.Person;
import thirdpartydependencies.daos.listeners.*;

public class EntityListener {

    public EntityListener() {
    }

    @PrePersist
    public void m1(Person entity) {
    }

    @PostPersist
    public void m2(Person entity) {
    }

    @PreUpdate
    public void m3(Person entity) {
    }

    @PostUpdate
    public void m4(Person entity) {
    }

    @PreRemove
    public void m5(Person entity) {
    }

    @PostRemove
    public void m6(Person entity) {
    }

    @PostLoad
    public void m7(Person entity) {
    }

}
