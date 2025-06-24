package gr.netmechanics.jmix.appcommons.entity;

import gr.netmechanics.jmix.appcommons.entity.util.DoNotCreateCustomizer;
import io.jmix.core.entity.annotation.SystemLevel;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Entity;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;

/**
 * The StandardLongEntityWorkaround class extends the StandardLongEntity class to address a specific
 * issue identified in the Jmix framework (refer to the referenced issue for details).
 * This class serves as a workaround implementation and may carry forward the standard
 * auditing and metadata features provided by the parent class.
 * <p>
 * See also issue: <a href="https://github.com/jmix-framework/jmix/issues/317">MappedSuperclass is enhanced incorrectly if it has no Entity subclasses in the module</a>
 */
@Entity
@ReadOnly
@JmixEntity
@SystemLevel
@Customizer(DoNotCreateCustomizer.class)
@SuppressWarnings("all")
class StandardLongEntityWorkaround extends StandardLongEntity {
}