import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Message class
class Message {
    private User sender;
    private List<User> recipients;
    private String timestamp;
    private String content;

    public Message(User sender, List<User> recipients, String timestamp, String content) {
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = timestamp;
        this.content = content;
    }

    // Getters
    public User getSender() {
        return sender;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }
}

// User class
class User {
    private String name;
    private ChatServer chatServer;
    private ChatHistory chatHistory;

    public User(String name, ChatServer chatServer) {
        this.name = name;
        this.chatServer = chatServer;
        this.chatHistory = new ChatHistory();
    }

    public void sendMessage(List<User> recipients, String content) {
        String timestamp = getCurrentTimestamp();
        Message message = new Message(this, recipients, timestamp, content);
        chatServer.sendMessage(message);
        chatHistory.addMessage(message);
        System.out.println(name + " sent message: " + content);
    }

    public void receiveMessage(Message message) {
        System.out.println(name + " received message: " + message.getContent());
    }

    public void undoLastMessage() {
        MessageMemento memento = chatHistory.getLastMessage();
        if (memento != null) {
            chatHistory.undoLastMessage();
            System.out.println(name + " undid the last message: " + memento.getContent());
        }
    }

    public void viewChatHistory() {
        System.out.println(name + "'s Chat History:");
        for (Message message : chatHistory.getMessages()) {
            System.out.println(message.getTimestamp() + " - " + message.getContent());
        }
    }

    public void searchMessagesByUser(String userName) {
        System.out.println(name + " searching messages by user: " + userName);
        Iterator iterator = chatHistory.iteratorByUser(userName);
        while (iterator.hasNext()) {
            Message message = iterator.next();
            System.out.println(message.getTimestamp() + " - " + message.getContent());
        }
    }

    // Getter
    public String getName() {
        return name;
    }

    // Helper method to get current timestamp
    private String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}

// ChatServer (Mediator) class
class ChatServer {
    private Map<String, User> users;
    private Map<User, List<User>> blockedUsers;

    public ChatServer() {
        users = new HashMap<>();
        blockedUsers = new HashMap<>();
    }

    public void registerUser(User user) {
        users.put(user.getName(), user);
    }

    public void unregisterUser(User user) {
        users.remove(user.getName());
    }

    public void sendMessage(Message message) {
        for (User recipient : message.getRecipients()) {
            if (!isBlocked(message.getSender(), recipient)) {
                recipient.receiveMessage(message);
            }
        }
    }

    public void blockUser(User user, User blockedUser) {
        List<User> blocked = blockedUsers.getOrDefault(user, new ArrayList<>());
        blocked.add(blockedUser);
        blockedUsers.put(user, blocked);
    }

    private boolean isBlocked(User sender, User recipient) {
        List<User> blocked = blockedUsers.getOrDefault(recipient, new ArrayList<>());
        return blocked.contains(sender);
    }
}

// ChatHistory class
class ChatHistory implements IterableByUser {
    private List<Message> messages;

    public ChatHistory() {
        messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public MessageMemento getLastMessage() {
        if (!messages.isEmpty()) {
            return new MessageMemento(messages.get(messages.size() - 1));
        }
        return null;
    }

    public void undoLastMessage() {
        if (!messages.isEmpty()) {
            messages.remove(messages.size() - 1);
        }
    }

    // Getter
    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public Iterator iteratorByUser(String userName) {
        return new IteratorByUser(messages, userName);
    }
}

// MessageMemento class
class MessageMemento {
    private String content;
    private String timestamp;

    public MessageMemento(Message message) {
        this.content = message.getContent();
        this.timestamp = message.getTimestamp();
    }

    // Getters
    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

// IterableByUser interface
interface IterableByUser {
    Iterator iteratorByUser(String userName);
}

// Iterator interface
interface Iterator {
    boolean hasNext();
    Message next();
}

// IteratorByUser class
class IteratorByUser implements Iterator {
    private List<Message> messages;
    private String userName;
    private int currentIndex;

    public IteratorByUser(List<Message> messages, String userName) {
        this.messages = messages;
        this.userName = userName;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < messages.size()) {
            Message message = messages.get(currentIndex);
            if (message.getSender().getName().equals(userName)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Message next() {
        if (hasNext()) {
            return messages.get(currentIndex++);
        }
        return null;
    }
}

// Driver class
public class ChatApplication {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User user1 = new User("User 1", chatServer);
        User user2 = new User("User 2", chatServer);
        User user3 = new User("User 3", chatServer);

        chatServer.registerUser(user1);
        chatServer.registerUser(user2);
        chatServer.registerUser(user3);

        List<User> recipients = new ArrayList<>();
        recipients.add(user2);
        recipients.add(user3);

        user1.sendMessage(recipients, "Hello, everyone!");
        user2.sendMessage(List.of(user1), "Hi, User 1!");
        user3.sendMessage(List.of(user1), "Hey, User 1!");

        user1.undoLastMessage();

        chatServer.blockUser(user2, user3);
        user3.sendMessage(List.of(user2), "This message should be blocked.");

        user1.viewChatHistory();
        user2.viewChatHistory();
        user3.viewChatHistory();

        user1.searchMessagesByUser("User 2");
    }
}