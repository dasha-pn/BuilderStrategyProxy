package lab11.Task2;

public interface MailStrategy {
    String generateSubject(Client client);
    String generateBody(Client client);
}

