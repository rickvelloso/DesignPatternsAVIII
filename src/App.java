import java.time.LocalDate;

import models.Event.EventInterface;
import models.Event.Reminder;
import notification.Notificator;

public class App {
    public static void main(String[] args) throws Exception {
        Notificator notificador = new Notificator();

        EventInterface evento1 = new Reminder(10, LocalDate.now(), LocalDate.now().plusDays(1), "Reunião Importante", "Sala 101");
        EventInterface evento2 = new Reminder(5, LocalDate.now(), LocalDate.now().plusDays(2), "Apresentação de Projeto", "Auditório");
        EventInterface evento3 = new Reminder(3, LocalDate.now().minusDays(1), LocalDate.now(), "Café com Equipe", "Cafeteria");

        System.out.println("\nNotificando evento 1:");
        notificador.notify(evento1);

        System.out.println("\nNotificando evento 2:");
        notificador.notify(evento2);

        System.out.println("\nNotificando evento 3:");
        notificador.notify(evento3);
    }
}
