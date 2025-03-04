package models.Event;

import java.time.LocalDate;

public class Reminder extends AbstractEvent {

    public Reminder(int priority, LocalDate startDate, LocalDate endDate, String description, String location) {
        super(priority, startDate, endDate, description, location);
    }

}
