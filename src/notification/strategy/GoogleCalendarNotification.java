package notification.strategy;

import models.Event.EventInterface;

public class GoogleCalendarNotification implements NotificationStrategy {

    @Override
    public void send(EventInterface event) {
        System.out.println("\n📆 Message added to google calendar:" +
                            "\n\tPriority: " + event.getPriority() +
                            "\n\tDescription: " + event.getDescription() +
                            "\n\tFrom: " + event.getStartDate() + "  to: " + event.getEndDate() +
                            "\n\tLocation: " + event.getLocation()
        );
    }

}
