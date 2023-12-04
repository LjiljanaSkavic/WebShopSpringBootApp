package springbootapp.services;

import springbootapp.models.Email;

public interface EmailService {
    void sendEmail(Email mail);
}
