package notification.strategy;

import models.Event.EventInterface;

public class SMSNotification implements NotificationStrategy {

    @Override
    public void send(EventInterface event) {
        System.out.println("\nMessage sent by SMS:\n" +
                "\n\tDescription: " + event.getDescription() +
                "\n\tStarts At: " + event.getStartDate() +
                "\n\tLocation: " + event.getLocation()
        );
    }

}
