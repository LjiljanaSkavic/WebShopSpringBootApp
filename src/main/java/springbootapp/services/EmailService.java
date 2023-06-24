package springbootapp.services;

import springbootapp.models.Email;

public interface EmailService {
    String sendMail(Email mail);
}
