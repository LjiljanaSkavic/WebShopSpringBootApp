package springbootapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springbootapp.models.Message;
import springbootapp.models.MessageRequest;
import springbootapp.services.implementation.ContactSupportServiceImplementation;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/contact-support-messages")
public class ContactSupportController {

    ContactSupportServiceImplementation contactSupportServiceImplementation;

    public ContactSupportController(ContactSupportServiceImplementation contactSupportServiceImplementation) {
        this.contactSupportServiceImplementation = contactSupportServiceImplementation;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Message insert(@RequestBody MessageRequest message) {
        return this.contactSupportServiceImplementation.insert(message, Message.class);
    }
}