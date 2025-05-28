package gr.netmechanics.jmix.appcommons.flowui.renderer;

import java.util.stream.Collectors;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.SerializableSupplier;
import gr.netmechanics.jmix.appcommons.entity.trait.HasTags;
import io.jmix.flowui.kit.component.ComponentUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Panos Bariamis (pbaris)
 */
public class TagsRenderer<T extends HasTags> extends ComponentRenderer<Component, T> {

    public TagsRenderer() {
        super((SerializableSupplier<Component>) null);
    }

    @Override
    public Component createComponent(final T item) {
        if (item.getTagValues() != null) {
            String tags = item.getTagValues().stream()
                .sorted()
                .collect(Collectors.joining("</span> <span class=\"ms-xs\" theme=\"badge small contrast\">"));

            if (StringUtils.isNotBlank(tags)) {
                Html tagsHtml = new Html("<div><span class=\"ms-xs\" theme=\"badge small contrast\">" + tags + "</span></div>");

                Icon icon = ComponentUtils.convertToIcon(VaadinIcon.TAGS);
                icon.setSize("16px");

                HorizontalLayout layout = new HorizontalLayout(icon, tagsHtml);
                layout.setSpacing(false);
                return layout;
            }
        }

        return new Span();
    }
}
