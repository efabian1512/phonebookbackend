package com.phonebook.myphonebookproject.dao;

import com.phonebook.myphonebookproject.models.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactDao extends CrudRepository<Contact,Integer> {
}
