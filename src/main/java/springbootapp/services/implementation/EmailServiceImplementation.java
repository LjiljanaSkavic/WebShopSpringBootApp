package springbootapp.services.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import springbootapp.models.Email;
import springbootapp.services.EmailService;

import java.util.Properties;

@Service
@PropertySource("classpath:application.properties")
public class EmailServiceImplementation implements EmailService {
    private Properties properties;

    private static final String SENDER_NAME = "Web shop app";
    private static final String SUBJECT = "Activation PIN";

    @Value("${spring.mail.username}")
    private String emailUsername;

    @Value("${spring.mail.password}")
    private String emailPassword;

    private JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(emailUsername);
        mailSender.setPassword(emailPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Override
    public void sendEmail(Email email) {
        JavaMailSender mailSender = getJavaMailSender();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailUsername);
        message.setTo(emailUsername);
        message.setSubject(email.getSubject());
        message.setText(email.getBody());

        mailSender.send(message);
    }
}
