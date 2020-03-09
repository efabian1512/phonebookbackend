/*package com.phonebook.myphonebookproject.dao;

import com.phonebook.myphonebookproject.models.Contact1;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeContactDataAccessService implements ContactDao1 {

    private static List<Contact1> DB = new ArrayList<>();

    @Override
    public int addContact(int id, Contact1 contact ){
        DB.add(new Contact1(id, contact.getName(),contact.getTelephone(),contact.getEmail()));
        return 1;
    }

    @Override
    public List<Contact1> selectAllContacts() {
        return DB;
    }

    @Override
    public Optional<Contact1> selectContactById(int id) {
        return DB.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst();
    }

    @Override
    public int deleteContactById(UUID id) {
        Optional<Contact1> contactMaybe = selectContactById(id);
        if(contactMaybe.isEmpty()){
            return 0;
        }
        DB.remove(contactMaybe.get());
        return 1;
    }

    @Override
    public int updateContactById(int id, Contact1 contactToUpdate) {
        return selectContactById(id)
                .map(contact ->{
                    int indexOfContactToUpdate = DB.indexOf(contact);
                    if(indexOfContactToUpdate >=0){
                        DB.set(indexOfContactToUpdate,new Contact1(id,contactToUpdate.getName(),
                                contactToUpdate.getTelephone(),contactToUpdate.getEmail()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);

    }
}*/
