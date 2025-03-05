package notification.builder;

import java.time.LocalDate;

import models.Event.EventInterface;
import models.Event.Reminder;

public class ReminderBuilder extends EventBuilder {

    public ReminderBuilder(int priority, LocalDate startDate, LocalDate endDate, String description, String location) {
        super(priority, startDate, endDate, description, location);
    }

    @Override
    public EventInterface doBuild() {
        return new Reminder(this);
    }

}
