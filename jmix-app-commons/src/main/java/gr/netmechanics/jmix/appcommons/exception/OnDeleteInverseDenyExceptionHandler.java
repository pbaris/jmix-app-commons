package gr.netmechanics.jmix.appcommons.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.flow.component.notification.Notification;
import io.jmix.core.Messages;
import io.jmix.flowui.Notifications;
import io.jmix.flowui.exception.AbstractUiExceptionHandler;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author Panos Bariamis (pbaris)
 */
@Component("jac_OnDeleteInverseDenyExceptionHandler")
@ConditionalOnProperty(name = "jmix.appcommons.on-delete-inverse-deny-exception-handler.enabled", matchIfMissing = true)
public class OnDeleteInverseDenyExceptionHandler extends AbstractUiExceptionHandler {

    private final Notifications notifications;
    private final Messages messages;

    private final Pattern pattern = Pattern.compile("delete.*?constraint\\s+\"([^\"]+)\"");

    @Autowired
    public OnDeleteInverseDenyExceptionHandler(final Notifications notifications, final Messages messages) {
        super(DatabaseException.class.getName());
        this.notifications = notifications;
        this.messages = messages;
    }

    @Override
    protected void doHandle(@NonNull final String className, @NonNull final String message, final Throwable throwable) {
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            String key = matcher.group(1);
            String errorMessage = messages.getMessage("databaseDeleteConstraintViolation.%s".formatted(key.toUpperCase()));

            notifications.create(errorMessage)
                .withType(Notifications.Type.ERROR)
                .withPosition(Notification.Position.BOTTOM_CENTER)
                .withDuration(3000)
                .show();
        }
    }
}