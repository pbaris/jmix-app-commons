package gr.netmechanics.jmix.appcommons.flowui.kit;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dialog.Dialog;
import io.jmix.flowui.app.inputdialog.InputDialog;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Panos Bariamis (pbaris)
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UiUtils {

    public static void fixInputDialogResponsiveUI(final InputDialog inputDialog) {
        fixInputDialogResponsiveUI(inputDialog, "35em");
    }

    public static void fixInputDialogResponsiveUI(final InputDialog inputDialog, final String maxWidth) {
        //TODO check if we can use UiComponentUtils.findDialog()

        Component parent = inputDialog.getParent().orElse(null);
        while (parent != null && !(parent instanceof Dialog)) {
            parent = parent.getParent().orElse(null);
        }

        if (parent instanceof Dialog dialog) {
            dialog.setMaxWidth(maxWidth);
            dialog.setWidth("100%");
        }
    }
}
