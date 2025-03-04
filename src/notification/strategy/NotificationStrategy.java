package notification.strategy;

import models.Event.EventInterface;

public interface NotificationStrategy {
    public void send(EventInterface event);
}
