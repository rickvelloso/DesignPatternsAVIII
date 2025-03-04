package notification;

import models.Event.EventInterface;
import notification.handler.EmailHandler;
import notification.handler.GoogleCalendarHandler;
import notification.handler.NotificationHandler;
import notification.handler.WhatsAppHandler;

public class Notificator {
    private NotificationHandler notificationChain;

    public Notificator() {
        this.notificationChain = new GoogleCalendarHandler();
        this.notificationChain
            .setNext(new WhatsAppHandler())
            .setNext(new EmailHandler());
    }

    public void notify(EventInterface event) {
        notificationChain.notify(event);
    }
}
