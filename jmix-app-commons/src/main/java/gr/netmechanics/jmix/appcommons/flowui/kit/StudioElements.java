package gr.netmechanics.jmix.appcommons.flowui.kit;

import io.jmix.flowui.kit.meta.StudioElement;
import io.jmix.flowui.kit.meta.StudioUiKit;

/**
 * @author Panos Bariamis (pbaris)
 */
@StudioUiKit
public interface StudioElements {

    @StudioElement(
        name = "BooleanRenderer",
        classFqn = "gr.netmechanics.jmix.appcommons.flowui.renderer.BooleanRenderer",
        xmlElement = "booleanRenderer",
        target = {"com.vaadin.flow.component.grid.Grid.Column"},
        unsupportedTarget = {"io.jmix.flowui.kit.component.grid.EditorActionsColumn"},
        xmlns = "http://schemas.netmechanics.gr/jmix/ui",
        xmlnsAlias = "nm"
    )
    void booleanRenderer();

    @StudioElement(
        name = "TagsRenderer",
        classFqn = "gr.netmechanics.jmix.appcommons.flowui.renderer.TagsRenderer",
        xmlElement = "tagsRenderer",
        target = {"com.vaadin.flow.component.grid.Grid.Column"},
        unsupportedTarget = {"io.jmix.flowui.kit.component.grid.EditorActionsColumn"},
        xmlns = "http://schemas.netmechanics.gr/jmix/ui",
        xmlnsAlias = "nm"
    )
    void tagsRenderer();
}
