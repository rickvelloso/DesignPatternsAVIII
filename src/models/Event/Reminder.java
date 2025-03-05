package models.Event;

import notification.builder.EventBuilder;

public class Reminder extends AbstractEvent {

    public Reminder(){super();};

    public Reminder(EventBuilder eventBuilder) {
        super(eventBuilder);
    }

}
