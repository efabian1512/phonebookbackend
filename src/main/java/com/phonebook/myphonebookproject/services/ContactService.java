package com.phonebook.myphonebookproject.services;

import com.phonebook.myphonebookproject.dao.ContactDao1;
import com.phonebook.myphonebookproject.models.Contact1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactService {

    private final ContactDao1 contactDao;

    @Autowired
    public ContactService(@Qualifier("MySql") ContactDao1 contactDao){
        this.contactDao = contactDao;
    }

    public int addPerson(Contact1 contact){
        return contactDao.addContact(contact);
    }

    public List<Contact1> getAllContacts(){
        return contactDao.selectAllContacts();
    }

    public Optional<Contact1> getContactById(String id){
        return contactDao.selectContactById(id);
    }

    public int deleteContactById(String id){
        return contactDao.deleteContactById(id);
    }

    public int updateContactById(String id, Contact1 newContact){
        return contactDao.updateContactById(id,newContact);
    }

}
