package notification.strategy;

import enums.ContactsEnum;
import models.Event.AbstractEvent;
import models.Event.EventInterface;

public class WhatsAppNotification implements NotificationStrategy {

    @Override
    public void send(EventInterface event) {

        String contact = ((AbstractEvent) event).getContact(ContactsEnum.WHATSAPP);

        if(contact != null)
            System.out.println("\nMessage sent to WhatsApp: " + contact +
                                "\n\tPriority: " + event.getPriority() +
                                "\n\tDescription: " + event.getDescription() +
                                "\n\tFrom: " + event.getStartDate() + "  to: " + event.getEndDate() +
                                "\n\tLocation: " + event.getLocation()
            );
    }

}
