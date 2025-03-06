package notification.handler;

import java.time.LocalDate;

import models.Event.EventInterface;
import notification.strategy.WhatsAppNotification;

public class WhatsAppHandler  extends NotificationHandler{

    public WhatsAppHandler() {
        super(new WhatsAppNotification());
    }

    @Override
    protected boolean canHandle(EventInterface event) {
        return event.getPriority() == 10 && event.startsAt(LocalDate.now());
    }

    @Override
    protected void processNotification(EventInterface event) {
        // ...Formatações para envia via WhatsApp
       super.strategy.send(event);
    }

}