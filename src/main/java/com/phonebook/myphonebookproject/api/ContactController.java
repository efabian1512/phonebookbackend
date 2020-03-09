package com.phonebook.myphonebookproject.api;

import com.phonebook.myphonebookproject.dao.ContactDao;
import com.phonebook.myphonebookproject.models.Contact;
import com.phonebook.myphonebookproject.models.Contact1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactDao contactDao;

     @PostMapping("/saveContact")
    public String saveContact(@RequestBody Contact contact) {

        contactDao.save(contact);
        return "Contact Saved:";

    }

    @GetMapping("/getContacts")
    public List<Contact> getAll() {
        return (List<Contact>) contactDao.findAll();
    }




}