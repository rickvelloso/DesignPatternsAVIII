package notification.strategy;

import models.Event.EventInterface;

public class EmailNotification implements NotificationStrategy {

    @Override
    public void send(EventInterface event) {
        System.out.println("\nMessage sent by email:" +
                            "\n\tPriority: " + event.getPriority() +
                            "\n\tDescription: " + event.getDescription() +
                            "\n\tStarts At: " + event.getStartDate() +
                            "\n\tLocation: " + event.getLocation()
        );
    }

}
