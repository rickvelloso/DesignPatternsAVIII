package notification.handler;

import models.Event.EventInterface;
import notification.strategy.NotificationStrategy;

// Interface base do Chain of Responsibility
public abstract class NotificationHandler {
    private NotificationHandler next;
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

    // Possui comportamento de envio padrão, mas pode ser sobreescrito pelas
    // classes filho, caso necessário alguma alteração comportamental
    protected void processNotification(EventInterface event) {
        this.strategy.send(event);
    }
}