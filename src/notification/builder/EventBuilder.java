package notification.builder;

import java.time.LocalDate;
import java.util.HashMap;

import enums.ContactsEnum;
import models.Event.EventInterface;

public abstract class EventBuilder {
    private int priority;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private HashMap<String, String> contacts = new HashMap<>();

    // Alguns dados são obrigatórios para criação do objeto Event
    public EventBuilder(int priority, LocalDate startDate, LocalDate endDate, String description, String location) {
        this.reset(priority, startDate, endDate, description, location);
    }

    // --------------------- BUILDERS ---------------------
    public EventBuilder priority(int priority){
        this.priority = priority;
        return this;
    }
    public EventBuilder description(String description){
        this.description = description;
        return this;
    }
    public EventBuilder startDate(LocalDate startDate){
        this.startDate = startDate;
        return this;
    }
    public EventBuilder endDate(LocalDate endDate){
        this.endDate = endDate;
        return this;
    }
    public EventBuilder location(String location){
        this.location = location;
        return this;
    }
    
    public EventBuilder contact(ContactsEnum key, String contact){
        this.contacts.put(key.getName(), contact);
        
        return this;
    }
    
    public EventBuilder reset(int priority, LocalDate startDate, LocalDate endDate, String description, String location) {
        this.priority = priority;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.location = location;
        this.contacts.clear();

        return this;
    }

    // Evita que os próximos elementos façam referencia ao HashMap anterior
    public EventInterface build() {
        EventInterface event = this.doBuild();
        this.contacts = new HashMap<>(this.contacts);

        return event;
    }

    public abstract EventInterface doBuild();


    // ----------------------- Getters -----------------------

    public int getPriority() {
        return priority;
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

    public HashMap<String, String> getContacts() {
        return contacts;
    }

}
