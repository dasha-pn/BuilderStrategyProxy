package lab11.Task2;

import java.util.EnumMap;
import java.util.Map;

public class MailSender {

    private final Map<MailCode, MailStrategy> strategies = new EnumMap<>(MailCode.class);
    private final MailJetService mailJetService;

    public MailSender(MailJetService mailJetService) {
        this.mailJetService = mailJetService;

        strategies.put(MailCode.BIRTHDAY, new BirthdayMailStrategy());
        strategies.put(MailCode.GIFT, new GiftMailStrategy());
    }

    public void sendMail(MailInfo info) {
        Client client = info.getClient();
        MailCode code = info.getMailCode();

        MailStrategy strategy = strategies.get(code);
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy registered for mail code: " + code);
        }

        String subject = strategy.generateSubject(client);
        String body = strategy.generateBody(client);

        mailJetService.send(
                client.getEmail(),
                client.getName(),
                subject,
                body.replace("\n", "<br/>")
        );
    }
}
