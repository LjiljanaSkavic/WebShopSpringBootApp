package springbootapp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootapp.models.Email;
import springbootapp.services.implementation.EmailServiceImplementation;

@RequestMapping("/email")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmailController {

    private final EmailServiceImplementation emailService;

    public EmailController(EmailServiceImplementation emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public void insert(@RequestBody Email mail) {
        emailService.sendEmail(mail);
    }

}
