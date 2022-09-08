package architecture.persistence.listener;

import architecture.persistence.entity.CustomEntity;
import thirdpartydependencies.*;

public class EntityListener {

    @PrePersist
    public void m1(CustomEntity entity) {
    }

    @PostPersist
    public void m2(CustomEntity entity) {
    }

    @PreUpdate
    public void m3(CustomEntity entity) {
    }

    @PostUpdate
    public void m4(CustomEntity entity) {
    }

    @PreRemove
    public void m5(CustomEntity entity) {
    }

    @PostRemove
    public void m6(CustomEntity entity) {
    }

    @PostLoad
    public void m7(CustomEntity entity) {
    }

}
