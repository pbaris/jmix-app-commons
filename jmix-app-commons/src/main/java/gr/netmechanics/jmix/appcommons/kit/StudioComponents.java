package gr.netmechanics.jmix.appcommons.kit;

import static io.jmix.flowui.kit.meta.StudioProperty.Category.GENERAL;
import static io.jmix.flowui.kit.meta.StudioProperty.Category.LOOK_AND_FEEL;
import static io.jmix.flowui.kit.meta.StudioProperty.Category.POSITION;
import static io.jmix.flowui.kit.meta.StudioProperty.Category.SIZE;

import gr.netmechanics.jmix.appcommons.flowui.component.ViewLink;
import io.jmix.flowui.kit.meta.StudioComponent;
import io.jmix.flowui.kit.meta.StudioProperty;
import io.jmix.flowui.kit.meta.StudioPropertyType;
import io.jmix.flowui.kit.meta.StudioUiKit;

/**
 * @author Panos Bariamis (pbaris)
 */
@StudioUiKit
public interface StudioComponents {
    @StudioComponent(
        name = "ViewLink",
        classFqn = "gr.netmechanics.jmix.appcommons.flowui.component.ViewLink",
        category = "Components",
        xmlElement = "viewLink",
        xmlns = "http://schemas.netmechanics.gr/jmix/ui",
        xmlnsAlias = "nm",
        icon = "gr/netmechanics/jmix/appcommons/kit/view_link.svg",
        properties = {
            @StudioProperty(xmlAttribute = "alignSelf", category = POSITION, type = StudioPropertyType.ENUMERATION,
                classFqn = "com.vaadin.flow.component.orderedlayout.FlexComponent$Alignment",
                defaultValue = "AUTO",
                options = {"START", "END", "CENTER", "STRETCH", "BASELINE", "AUTO"}),
            @StudioProperty(xmlAttribute = "classNames", category = LOOK_AND_FEEL, type = StudioPropertyType.VALUES_LIST),
            @StudioProperty(xmlAttribute = "css", category = LOOK_AND_FEEL, type = StudioPropertyType.STRING),
            @StudioProperty(xmlAttribute = "colspan", category = POSITION, type = StudioPropertyType.INTEGER),
            @StudioProperty(xmlAttribute = "icon", category = LOOK_AND_FEEL, type = StudioPropertyType.ICON),
            @StudioProperty(xmlAttribute = "id", category = GENERAL, type = StudioPropertyType.COMPONENT_ID),
            @StudioProperty(xmlAttribute = "size", category = SIZE, type = StudioPropertyType.SIZE),
            @StudioProperty(xmlAttribute = "text", category = GENERAL, type = StudioPropertyType.LOCALIZED_STRING),
            @StudioProperty(xmlAttribute = "view", category = GENERAL, type = StudioPropertyType.STRING),
            @StudioProperty(xmlAttribute = "visible", category = GENERAL, type = StudioPropertyType.BOOLEAN, defaultValue = "true")
        }
    )
    ViewLink viewLink();
}
