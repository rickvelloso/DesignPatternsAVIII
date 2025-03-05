package models.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import enums.ContactsEnum;
import notification.builder.EventBuilder;

public abstract class AbstractEvent implements EventInterface{
    private int priority;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String location;
    private HashMap<String, String> contacts = new HashMap<>();

    public AbstractEvent(){}

    public AbstractEvent(EventBuilder eventBuilder) {
        this.priority = eventBuilder.getPriority();
        this.startDate = eventBuilder.getStartDate();
        this.endDate = eventBuilder.getEndDate();
        this.description = eventBuilder.getDescription();
        this.location = eventBuilder.getLocation();
        this.contacts = eventBuilder.getContacts();
    }

    public int getPriority() {
        return priority;
    }

    public boolean startsAt(LocalDate date) {
        return this.startDate.equals(date);
    }

    public boolean startsBetween(LocalDateTime start, LocalDateTime end) {
        LocalDateTime eventDate = startDate.atStartOfDay();
        return !eventDate.isBefore(start) && !eventDate.isAfter(end);
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public String getContact(ContactsEnum key) {
        return contacts.get(key.getName());
    }
}
