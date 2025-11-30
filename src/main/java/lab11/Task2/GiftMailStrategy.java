package lab11.Task2;

public class GiftMailStrategy implements MailStrategy {
    @Override
    public String generateSubject(Client client) {
        return "A special gift just for you!";
    }

    @Override
    public String generateBody(Client client) {
        return "Hello " + client.getName() + ",\n\n" +
               "We have prepared a special gift for you. " +
               "Come and get it in our store or check your profile online.\n\n" +
               "Cheers,\nYour Company";
    }
}
