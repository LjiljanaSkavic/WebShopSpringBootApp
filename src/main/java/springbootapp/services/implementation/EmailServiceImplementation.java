package springbootapp.services.implementation;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import springbootapp.models.Email;
import springbootapp.services.EmailService;

@Service
public class EmailServiceImplementation implements EmailService {
    private static final String SENDER_NAME = "WebShop";

    private static final String TITLE = "PIN for registration";

    private final JavaMailSender javaMailSender;

    public EmailServiceImplementation(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String sendMail(Email mail) {

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(SENDER_NAME);
            mailMessage.setTo(mail.getReceiver());
            mailMessage.setText(mail.getContent());
            mailMessage.setSubject(TITLE);

            javaMailSender.send(mailMessage);

            return "Mail sent!";

        } catch (Exception e) {
            return "Error while sending mail!";
        }
    }
}
