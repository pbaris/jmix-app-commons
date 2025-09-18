package gr.netmechanics.jmix.appcommons.flowui.delegate;

import static io.jmix.core.common.util.Preconditions.checkNotNullArgument;

import java.util.Locale;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.data.provider.HasDataView;
import com.vaadin.flow.data.provider.HasListDataView;
import com.vaadin.flow.internal.LocaleUtil;
import gr.netmechanics.jmix.appcommons.util.CollatorComparator;
import gr.netmechanics.jmix.appcommons.util.EnumSortLocalized;
import io.jmix.core.Messages;
import io.jmix.core.metamodel.datatype.EnumClass;
import io.jmix.flowui.component.delegate.DataViewDelegate;
import io.jmix.flowui.data.SupportsDataProvider;
import io.jmix.flowui.data.items.EnumDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.NonNull;

/**
 * @author Panos Bariamis (pbaris)
 */
@Primary
@org.springframework.stereotype.Component("jac_ExtDataViewDelegate")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ExtDataViewDelegate<C extends Component & HasDataView<V, ?, ?> & HasListDataView<V, ?> & SupportsDataProvider<V>, V>
    extends DataViewDelegate<C, V> {

    private Messages messages;

    public ExtDataViewDelegate(final C component) {
        super(component);
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void setItems(@NonNull final Class<V> itemsEnum) {
        checkNotNullArgument(itemsEnum);

        if (!itemsEnum.isEnum() || !EnumClass.class.isAssignableFrom(itemsEnum)) {
            throw new IllegalArgumentException(String.format("Items class '%s' must be enumeration and implement %s",
                itemsEnum, EnumClass.class.getSimpleName()));
        }

        if (!EnumSortLocalized.class.isAssignableFrom(itemsEnum)) {
            super.setItems(itemsEnum);
            return;
        }

        Locale locale = LocaleUtil.getLocale(LocaleUtil::getI18NProvider);

        EnumDataProvider<V> dataProvider = new EnumDataProvider<>(itemsEnum);
        dataProvider.setSortComparator(new CollatorComparator<>(locale, c -> {
            EnumSortLocalized<V> v = (EnumSortLocalized<V>) c;
            return v.getLocalizedSortFunction().apply(messages, c);
        }));

        ((HasListDataView) component).setItems(dataProvider);
    }

    @Autowired
    public void setMessages(final Messages messages) {
        this.messages = messages;
    }
}