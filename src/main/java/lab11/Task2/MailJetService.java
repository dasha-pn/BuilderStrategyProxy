package lab11.Task2;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class MailJetService {

    private final MailjetClient client;
    private final String fromEmail;
    private final String fromName;

    public MailJetService(String apiKeyPublic, String apiKeyPrivate,
                          String fromEmail, String fromName) {

        ClientOptions options = ClientOptions.builder()
                .apiKey(apiKeyPublic)
                .apiSecretKey(apiKeyPrivate)
                .build();

        this.client = new MailjetClient(options);
        this.fromEmail = fromEmail;
        this.fromName = fromName;
    }

    public void send(String toEmail, String toName,
                     String subject, String htmlBody) {
        try {
            MailjetRequest request = new MailjetRequest(Emailv31.resource)
                    .property(Emailv31.MESSAGES, new JSONArray()
                            .put(new JSONObject()
                                    .put(Emailv31.Message.FROM, new JSONObject()
                                            .put("Email", fromEmail)
                                            .put("Name", fromName))
                                    .put(Emailv31.Message.TO, new JSONArray()
                                            .put(new JSONObject()
                                                    .put("Email", toEmail)
                                                    .put("Name", toName)))
                                    .put(Emailv31.Message.SUBJECT, subject)
                                    .put(Emailv31.Message.HTMLPART, htmlBody)
                            ));

            MailjetResponse response = client.post(request);
            System.out.println("Mailjet status: " + response.getStatus());
            System.out.println("Mailjet response: " + response.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
