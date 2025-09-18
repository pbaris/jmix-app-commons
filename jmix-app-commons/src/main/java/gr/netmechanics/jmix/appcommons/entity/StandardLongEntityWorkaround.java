package gr.netmechanics.jmix.appcommons.entity;

import io.jmix.core.entity.annotation.SystemLevel;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Entity;

/**
 * The StandardLongEntityWorkaround class extends the StandardLongEntity class to address a specific
 * issue identified in the Jmix framework (refer to the referenced issue for details).
 * <p>
 * See also issue: <a href="https://github.com/jmix-framework/jmix/issues/317">MappedSuperclass is enhanced incorrectly if it has no Entity subclasses in the module</a>
 */
@Entity
@JmixEntity
@SystemLevel
@SuppressWarnings("all")
class StandardLongEntityWorkaround extends StandardLongEntity {
}