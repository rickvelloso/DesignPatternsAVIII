import java.time.LocalDate;

import enums.ContactsEnum;
import models.Event.EventInterface;
import notification.Notificator;
import notification.builder.EventBuilder;
import notification.builder.ReminderBuilder;

public class App {

    public void withBuilder() {
        Notificator notificador = new Notificator();
        // Alguns dados são obrigatórios para criação do objeto Event
        EventBuilder reminderBuilder = new ReminderBuilder(10, LocalDate.now(), LocalDate.now().plusDays(1), "Reunião Importante", "Sala 101");

        EventInterface evento1 = reminderBuilder
            .contact(ContactsEnum.WHATSAPP, "(71) 9 7070-7070")
            .contact(ContactsEnum.EMAIL, "meuEmail@gmail.com")
            .build();

        // Reaproveitando os dados do builder mas alterando a descrição e o WhatsApp, mantendo o email
        EventInterface evento4 = reminderBuilder
            .description("Reunião Importante Parte 2")
            .contact(ContactsEnum.WHATSAPP, "(16) 9 5133-9615")
            .build();

        EventInterface evento2 = reminderBuilder
            .reset(5, LocalDate.now(), LocalDate.now().plusDays(2), "Apresentação de Projeto", "Auditório")
            .contact(ContactsEnum.EMAIL, "teste@gmail.com")
            .build();

        EventInterface evento3 = reminderBuilder
            .reset(3, LocalDate.now().minusDays(1), LocalDate.now(), "Café com Equipe", "Cafeteria")
            .contact(ContactsEnum.EMAIL, "empresarial@gmail.com")
            .build();

        System.out.println("\nNotificando evento 1:");
        notificador.notify(evento1);

        System.out.println("\nNotificando evento 2:");
        notificador.notify(evento2);

        System.out.println("\nNotificando evento 3:");
        notificador.notify(evento3);

        System.out.println("\nNotificando evento 4:");
        notificador.notify(evento4);
    }

    public static void main(String[] args) throws Exception {
        (new App()).withBuilder(); 
    }
}
