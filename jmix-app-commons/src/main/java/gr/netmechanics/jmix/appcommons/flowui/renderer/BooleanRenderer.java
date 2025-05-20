package gr.netmechanics.jmix.appcommons.flowui.renderer;

import static com.vaadin.flow.component.icon.VaadinIcon.CHECK_CIRCLE;
import static com.vaadin.flow.component.icon.VaadinIcon.CLOSE_CIRCLE;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.SerializableSupplier;
import com.vaadin.flow.function.ValueProvider;

/**
 * @author Panos Bariamis (pbaris)
 */
public class BooleanRenderer<S> extends ComponentRenderer<Component, S> {

    private final ValueProvider<S, Boolean> valueProvider;

    public BooleanRenderer(final ValueProvider<S, Boolean> valueProvider) {
        super((SerializableSupplier<Component>) null);
        this.valueProvider = valueProvider;
    }

    @Override
    public Component createComponent(final S item) {
        boolean yes = Boolean.TRUE.equals(valueProvider.apply(item));

        Icon icon = yes ? CHECK_CIRCLE.create() : CLOSE_CIRCLE.create();
        icon.addClassName("bool-icon");
        icon.addClassName(yes ? "yes" : "no");
        return icon;
    }
}
