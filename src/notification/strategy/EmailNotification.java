package notification.strategy;

import enums.ContactsEnum;
import models.Event.AbstractEvent;
import models.Event.EventInterface;

public class EmailNotification implements NotificationStrategy {

    @Override
    public void send(EventInterface event) {
        String email = ((AbstractEvent) event).getContact(ContactsEnum.EMAIL);

        if(email != null)
            System.out.println("\nMessage sent by email: " + email +
                                "\n\tPriority: " + event.getPriority() +
                                "\n\tDescription: " + event.getDescription() +
                                "\n\tFrom: " + event.getStartDate() + "  to: " + event.getEndDate() +
                                "\n\tLocation: " + event.getLocation()
            );
    }

}
