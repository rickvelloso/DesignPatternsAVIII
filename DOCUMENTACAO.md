# Análise de Padrões de Projeto e Documentação

## 1. Builder Pattern

### Justificativa
- **Problema resolvido:** A criação de objetos “Evento” envolve vários atributos obrigatórios e opcionais.
- **Benefícios:**
  - Separa o processo de construção da representação final, tornando o código mais legível e fácil de manter.
  - Permite o reaproveitamento do builder para criar diferentes instâncias (como observado com o método `reset`).
  - Facilita a construção de objetos imutáveis ou sem a necessidade de múltiplos construtores.

### Classes Participantes
- **`EventBuilder` (abstrata):**
  - Contém os atributos e métodos comuns para construir um objeto do tipo evento (como prioridade, datas, descrição, localização e contatos).
  - Fornece métodos “fluent” para definir os valores e um método `build()` que delega a construção ao método abstrato `doBuild()`.
  
- **`ReminderBuilder` (concreta):**
  - Estende `EventBuilder` e implementa o método `doBuild()`, retornando uma instância de `Reminder`.
  - Permite a criação específica de um evento do tipo “Reminder”.

- **`AbstractEvent` e `EventInterface`:**
  - Representam a abstração do produto que está sendo construído.
  - `AbstractEvent` fornece implementações comuns, enquanto `EventInterface` define o contrato.

- **`Reminder`:**
  - Classe concreta que representa um tipo específico de evento, construído por meio do `ReminderBuilder`.

---

## 2. Chain of Responsibility Pattern

### Justificativa
- **Problema resolvido:** Há a necessidade de selecionar dinamicamente o canal de notificação mais adequado para um evento, de acordo com critérios como prioridade e data.
- **Benefícios:**
  - Permite que múltiplos handlers tentem processar a notificação sem acoplamento rígido entre o remetente e os receptores.
  - Facilita a adição ou remoção de canais de notificação sem alterar a lógica central.

### Classes Participantes
- **`NotificationHandler` (abstrata):**
  - Define o método `notify(EventInterface event)` que verifica se o handler pode processar o evento (via `canHandle`) e, caso positivo, executa o processamento (via `processNotification`).
  - Contém um atributo `next` para apontar para o próximo handler na cadeia.

- **Handlers Concretos:**
  - **`GoogleCalendarHandler`:**
    - Inicialmente na cadeia, trata notificações (aqui, o método `canHandle` retorna `true` para todos os eventos, atuando como fallback).
  - **`WhatsAppHandler`:**
    - Processa eventos que atendem a condições específicas (por exemplo, prioridade igual a 10 e data atual).
  - **`EmailHandler`:**
    - Processa eventos com prioridade elevada ou que caem em um intervalo de datas definido.

- **`Notificator`:**
  - Classe responsável por montar a cadeia de responsabilidade.
  - Instancia os handlers e os encadeia (GoogleCalendarHandler → WhatsAppHandler → EmailHandler) para que, ao chamar `notify`, cada handler tenha a chance de processar o evento.

---

## 3. Strategy Pattern

### Justificativa
- **Problema resolvido:** Diferentes métodos de notificação (email, WhatsApp, Google Calendar, SMS) possuem algoritmos distintos para o envio da mensagem.
- **Benefícios:**
  - Encapsula cada algoritmo de envio em sua própria classe, permitindo a troca ou extensão dos métodos de notificação sem impactar o restante do código.
  - Promove a reutilização e a intercambialidade das estratégias de notificação.

### Classes Participantes
- **`NotificationStrategy` (interface):**
  - Define o método `send(EventInterface event)` que todas as estratégias de notificação devem implementar.

- **Implementações Concretas:**
  - **`EmailNotification`:**
    - Implementa o envio de notificações por email, extraindo o contato de email do evento.
  - **`GoogleCalendarNotification`:**
    - Implementa a notificação via Google Calendar, adicionando o evento ao calendário.
  - **`WhatsAppNotification`:**
    - Implementa a notificação via WhatsApp, enviando a mensagem para o número especificado.
  - **`SMSNotification`:**
    - Embora não seja diretamente utilizada na cadeia de handlers apresentada, está implementada para o envio de SMS.

- **Integração com os Handlers:**
  - Cada `NotificationHandler` possui uma referência a um objeto que implementa `NotificationStrategy` (por exemplo, o `EmailHandler` é construído com um `EmailNotification`), delegando assim o envio real da mensagem à estratégia configurada.

---

## Considerações Finais

A combinação desses três padrões (Builder, Chain of Responsibility e Strategy) proporciona uma arquitetura modular, flexível e de fácil manutenção:

- **Builder Pattern:** Simplifica a criação de objetos complexos com múltiplos parâmetros, evitando a proliferação de construtores e facilitando o reaproveitamento do builder.
- **Chain of Responsibility Pattern:** Permite a distribuição das responsabilidades de notificação por diferentes canais, com cada handler avaliando se pode processar o evento, sem conhecimento dos demais.
- **Strategy Pattern:** Isola os algoritmos de envio de notificações, tornando possível a adição ou substituição de canais sem a necessidade de alterar a lógica dos handlers.

