package com.phonebook.myphonebookproject.api;

import com.phonebook.myphonebookproject.models.Contact1;
import com.phonebook.myphonebookproject.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/contact")
@RestController
public class ContactController1 {

    private final ContactService contactService;

    @Autowired
    public ContactController1(ContactService contactService){
        this.contactService = contactService;
    }

    @PostMapping
    public void addContact(@Valid @NonNull @RequestBody Contact1 contact){
        contactService.addPerson(contact);
    }

    @GetMapping
    public List<Contact1> getAllContacts(){
        return contactService.getAllContacts();
    }

    @GetMapping(path = "{id}")
    public Contact1 getContactById( @PathVariable("id") int id){
        return contactService.getContactById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteContactById(@PathVariable("id") int id){
      contactService.deleteContactById(id);
    }

    @PutMapping(path = "{id}")
    public void updateContact(@PathVariable("id") int id,@Valid @NonNull @RequestBody Contact1 contactToUpdate ){
      contactService.updateContactById(id,contactToUpdate);
    }
}
