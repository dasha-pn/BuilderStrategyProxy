package lab11.Task2;

public class Main {
    public static void main(String[] args) {

        String apiKeyPublic  = "...";
        String apiKeyPrivate = "...";
        String fromEmail = "ksnthfnehf@gmail.com";
        String fromName  = "Lab11 Test";

        MailJetService mailJetService =
                new MailJetService(apiKeyPublic, apiKeyPrivate, fromEmail, fromName);

        MailSender sender = new MailSender(mailJetService);
        MailBox mailBox = new MailBox(sender);

        Client c1 = new Client("Daryna", 18, Sex.FEMALE, "ksnthfnehf@gmail.com");
        Client c2 = new Client("Arsenii", 13, Sex.MALE, "d.shevchuk.pn@ucu.edu.ua");

        mailBox.addMailInfo(new MailInfo(c1, MailCode.BIRTHDAY));
        mailBox.addMailInfo(new MailInfo(c2, MailCode.GIFT));

        mailBox.sendAll();
    }
}
