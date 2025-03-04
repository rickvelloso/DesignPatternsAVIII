package notification.handler;

import models.Event.EventInterface;
import notification.strategy.GoogleCalendarNotification;

public class GoogleCalendarHandler extends NotificationHandler{

    public GoogleCalendarHandler() {
        super(new GoogleCalendarNotification());
    }

    @Override
    protected boolean canHandle(EventInterface event) {
        return event.getPriority() >= 1;
    }

    @Override
    protected void processNotification(EventInterface event) {
       super.strategy.send(event);
    }

}