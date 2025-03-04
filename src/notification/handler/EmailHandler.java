package notification.handler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import models.Event.EventInterface;
import notification.strategy.EmailNotification;

public class EmailHandler extends NotificationHandler {

    public EmailHandler() {
        super(new EmailNotification());
    }

    @Override
    protected boolean canHandle(EventInterface event) {
        return (event.getPriority() >= 5 && event.startsAt(LocalDate.now())) ||
               (event.getPriority() >= 1 && event.startsBetween(LocalDateTime.now().minus(2, ChronoUnit.DAYS), LocalDateTime.now()));
    }

    @Override
    protected void processNotification(EventInterface event) {
       super.strategy.send(event);
    }

}
