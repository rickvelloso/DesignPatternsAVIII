package notification.handler;

import models.Event.EventInterface;
import notification.strategy.NotificationStrategy;

// Interface base do Chain of Responsibility
public abstract class NotificationHandler {
    protected NotificationHandler next;
    protected NotificationStrategy strategy;

    public NotificationHandler(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public NotificationHandler setNext(NotificationHandler next) {
        this.next = next;
        return next;
    }

    public void notify(EventInterface event) {
        if (canHandle(event)) {
            processNotification(event);
        }
        
        if (next != null) {
            next.notify(event);
        }
    }

    protected abstract boolean canHandle(EventInterface event);
    protected abstract void processNotification(EventInterface event);
}