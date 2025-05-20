package gr.netmechanics.jmix.appcommons.flowui.renderer;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Comparator;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.SerializableSupplier;
import com.vaadin.flow.theme.lumo.LumoUtility;
import gr.netmechanics.jmix.appcommons.entity.trait.HasListColumnLabel;
import io.jmix.flowui.Dialogs;
import io.jmix.flowui.view.MessageBundle;

/**
 * @author Panos Bariamis (pbaris)
 */
//TODO finish it
public abstract class AbstractListColumnRenderer<T, E extends HasListColumnLabel> extends ComponentRenderer<Component, T> {

    private final MessageBundle messageBundle;
    private final Dialogs dialogs;
    private final String messagePrefix;

    protected AbstractListColumnRenderer(final String messagePrefix) {
        super((SerializableSupplier<Component>) null);
        this.messageBundle = null;//AppBeans.getBean(MessageBundle.class);
        this.messageBundle.setMessageGroup(getClass().getPackageName());
        this.dialogs = null;//AppBeans.getBean(Dialogs.class);
        this.messagePrefix = messagePrefix;
    }

    protected abstract Collection<E> getItems(final T item);

    @Override
    public Component createComponent(final T item) {
        Collection<E> items = getItems(item);
        boolean hasItems = items != null && !items.isEmpty();

        String message = messageBundle.getMessage(messagePrefix + ".count");
        message = MessageFormat.format(message, hasItems ? items.size() : 0);

        Span badge = new Span(message);
        badge.getElement().getThemeList().add("badge small " + (hasItems ? "" : "contrast"));
        badge.addClassName(LumoUtility.Margin.Start.XSMALL);

        if (hasItems) {
            StringBuilder htmlContent = new StringBuilder("<ul class='m-m p-m'>");
            items.stream()
                .sorted(Comparator.comparing(HasListColumnLabel::getListColumnLabel))
                .forEach(it -> htmlContent.append("<li>").append(it.getListColumnLabel()).append("</li>"));
            htmlContent.append("</ul>");

            badge.addClickListener(e -> dialogs.createMessageDialog()
                .withHeader(messageBundle.getMessage(messagePrefix + ".title"))
                .withContent(new Html(htmlContent.toString()))
                .withCloseOnOutsideClick(true)
                .open());
        }

        return badge;
    }
}
