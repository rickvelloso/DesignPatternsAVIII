package models.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public abstract class AbstractEvent implements EventInterface{
    private int priority;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String location;
    // private HashMap<String, String> contacts = new HashMap<>();

    public AbstractEvent(int priority, LocalDate startDate, LocalDate endDate, String description, String location) {
        this.priority = priority;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.location = location;
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

    public String getLocation() {
        return location;
    }
}
