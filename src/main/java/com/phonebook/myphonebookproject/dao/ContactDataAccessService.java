package com.phonebook.myphonebookproject.dao;

import com.phonebook.myphonebookproject.models.Contact1;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MySql")
public class ContactDataAccessService implements ContactDao1 {
    private final JdbcTemplate jdbcTemplate;

    public ContactDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addContact(Contact1 contact) {
        String sql = "INSERT into contacts (name,telephone,email) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{contact.getName(),contact.getTelephone(),contact.getEmail()} );
        return 1;
    }

    @Override
    public List<Contact1> selectAllContacts() {
        final String sql = "SELECT id, name, telephone, email FROM contacts";
        return jdbcTemplate.query(sql,(resultSet, index) -> {
            int id = (resultSet.getInt("id"));
            String name = resultSet.getString("name");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            return new Contact1(id,name,telephone,email);
        });


    }

    @Override
    public Optional<Contact1> selectContactById(int id) {
        final String sql = "SELECT id,name,telephone,email FROM contacts WHERE id = ?";

        Contact1 contact = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet,index) ->{
                    int contactId = (resultSet.getInt("id"));
                    String name = resultSet.getString("name");
                    String telephone = resultSet.getString("telephone");
                    String email = resultSet.getString("email");
                    return new Contact1(contactId,name,telephone,email);


                });
        return Optional.ofNullable(contact);
    }

    @Override
    public int deleteContactById(int id) {
        String sqlDelete = "DELETE from contacts WHERE id=?";
        Optional<Contact1> contactMaybe = selectContactById(id);
        if(contactMaybe.isEmpty()){
            return 0;
        }
        jdbcTemplate.update(sqlDelete,new Object[]{id});
        return 1;

    }

    @Override
    public int updateContactById(int id, Contact1 contact) {
        String sqlUpdate = "UPDATE contacts SET name= ?, telephone=?,email=? WHERE id=?";
        Optional<Contact1> contactMaybe = selectContactById(id);

        if(contactMaybe.isEmpty()){
            return 0;
        }
        jdbcTemplate.update(sqlUpdate,new Object[]{contact.getName(),contact.getTelephone(),contact.getEmail(),id});
        return 1;

    }
}
