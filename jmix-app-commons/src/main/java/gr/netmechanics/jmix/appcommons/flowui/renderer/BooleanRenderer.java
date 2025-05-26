package gr.netmechanics.jmix.appcommons.flowui.renderer;

import static com.vaadin.flow.component.icon.VaadinIcon.CHECK_CIRCLE;
import static com.vaadin.flow.component.icon.VaadinIcon.CLOSE_CIRCLE;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.SerializableSupplier;
import com.vaadin.flow.function.ValueProvider;

/**
 * @author Panos Bariamis (pbaris)
 */
public class BooleanRenderer<S> extends ComponentRenderer<Component, S> {

    private final ValueProvider<S, Boolean> valueProvider;
    private final boolean allowNull;

    public BooleanRenderer(final ValueProvider<S, Boolean> valueProvider, boolean allowNull) {
        super((SerializableSupplier<Component>) null);
        this.valueProvider = valueProvider;
        this.allowNull = allowNull;
    }

    @Override
    public Component createComponent(final S item) {
        Boolean value = valueProvider.apply(item);
        if (allowNull && value == null) {
            return new Span();
        }

        boolean yes = Boolean.TRUE.equals(value);

        Icon icon = yes ? CHECK_CIRCLE.create() : CLOSE_CIRCLE.create();
        icon.addClassName("bool-icon");
        icon.addClassName(yes ? "yes" : "no");
        return icon;
    }
}
