package lab11.Task2;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private final List<MailInfo> infos = new ArrayList<>();
    private final MailSender mailSender;

    public MailBox(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void addMailInfo(MailInfo info) {
        infos.add(info);
    }

    public void sendAll() {
        for (MailInfo info : infos) {
            mailSender.sendMail(info);
        }
        infos.clear();
    }
}
