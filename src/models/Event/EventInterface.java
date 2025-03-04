package models.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface EventInterface {
    public String getDescription();
    public LocalDate getStartDate();
    public String getLocation();
    public int getPriority();
    public boolean startsAt(LocalDate date);
    public boolean startsBetween(LocalDateTime start, LocalDateTime end);
}
