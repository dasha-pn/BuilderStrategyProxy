package lab11.Task2;

public class BirthdayMailStrategy implements MailStrategy {
    @Override
    public String generateSubject(Client client) {
        return "Happy Birthday, " + client.getName() + "!";
    }

    @Override
    public String generateBody(Client client) {
        return "Dear " + client.getName() + ",\n\n" +
               "We wish you a wonderful birthday and an amazing year ahead!\n\n" +
               "Best regards,\nYour Company";
    }
}
