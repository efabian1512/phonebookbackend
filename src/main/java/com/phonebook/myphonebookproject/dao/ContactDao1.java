package com.phonebook.myphonebookproject.dao;

import com.phonebook.myphonebookproject.models.Contact1;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactDao1 {

    int addContact(Contact1 contact);

   /* default int addContact(Contact1 contact){
        //UUID id = int.randomUUID();
        return addContact(id, contact);
    }*/

    List<Contact1> selectAllContacts();

    Optional<Contact1> selectContactById(int id);

    int deleteContactById(int id);

    int updateContactById(int id, Contact1 contact);
}
