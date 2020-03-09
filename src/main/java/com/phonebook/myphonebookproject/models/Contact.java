package com.phonebook.myphonebookproject.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {

    @Id
    @GeneratedValue
    private int id;
    private String telephone;
    private String name;
    private String email;


}
