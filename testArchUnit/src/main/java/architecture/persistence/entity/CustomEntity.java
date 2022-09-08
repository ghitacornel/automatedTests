package architecture.persistence.entity;

import thirdpartydependencies.Entity;
import thirdpartydependencies.ManyToMany;
import thirdpartydependencies.OneToMany;
import thirdpartydependencies.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class CustomEntity extends EntityTemplate {

    @OneToMany
    final List<Object> oneToMany = new ArrayList<>();

    @ManyToMany
    final List<Object> manyToMany = new ArrayList<>();

}
