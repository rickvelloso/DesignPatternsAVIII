package notification.strategy;

import enums.ContactsEnum;
import models.Event.AbstractEvent;
import models.Event.EventInterface;

public class SMSNotification implements NotificationStrategy {

    @Override
    public void send(EventInterface event) {

        String contact = ((AbstractEvent) event).getContact(ContactsEnum.NUMBER);
        if(contact != null)
            System.out.println("\nMessage sent by SMS: " + contact +
                    "\n\tDescription: " + event.getDescription() +
                    "\n\tFrom: " + event.getStartDate() + "  to: " + event.getEndDate() +
                    "\n\tLocation: " + event.getLocation()
            );
    }

}
