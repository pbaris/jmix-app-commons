package gr.netmechanics.jmix.appcommons.flowui.view;

import java.util.Map;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasLabel;
import io.jmix.appsettings.AppSettingsTools;
import io.jmix.appsettings.entity.AppSettingsEntity;
import io.jmix.core.Messages;
import io.jmix.flowui.component.SupportsTypedValue;
import io.jmix.flowui.data.SupportsValueSource;
import io.jmix.flowui.data.value.ContainerValueSource;
import io.jmix.flowui.model.DataComponents;
import io.jmix.flowui.view.StandardDetailView;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Panos Bariamis (pbaris)
 */
public abstract class StandardSettingsDetailView<T extends AppSettingsEntity> extends StandardDetailView<T> {

    protected Messages messages;
    protected DataComponents dataComponents;
    protected AppSettingsTools appSettingsTools;

    protected abstract Class<T> getEntityClass();

    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void adjustDefaultField(final AbstractField field, final String propertyName) {
        Class<T> entityClass = getEntityClass();

        if (field instanceof SupportsValueSource vsf) {
            vsf.setValueSource(new ContainerValueSource<>(dataComponents.createInstanceContainer(entityClass), propertyName));
        }

        if (field instanceof SupportsTypedValue stvf) {
            stvf.setTypedValue(appSettingsTools.getDefaultPropertyValue(entityClass, propertyName));

        } else {
            field.setValue(appSettingsTools.getDefaultPropertyValue(entityClass, propertyName));
        }
        field.setReadOnly(true);

        if (field instanceof HasLabel hasLabel) {
            hasLabel.setLabel(messages.getMessage(StandardSettingsDetailView.class, "StandardSettingsDetailView.defaultValue"));
        }
    }

    protected Map<Boolean, String> getYesNoMap() {
        return Map.of(
            Boolean.TRUE, messages.getMessage(StandardSettingsDetailView.class, "StandardSettingsDetailView.yes"),
            Boolean.FALSE, messages.getMessage(StandardSettingsDetailView.class, "StandardSettingsDetailView.no"));
    }

    @Autowired
    public void setMessages(final Messages messages) {
        this.messages = messages;
    }

    @Autowired
    public void setDataComponents(final DataComponents dataComponents) {
        this.dataComponents = dataComponents;
    }

    @Autowired
    public void setAppSettingsTools(final AppSettingsTools appSettingsTools) {
        this.appSettingsTools = appSettingsTools;
    }
}
