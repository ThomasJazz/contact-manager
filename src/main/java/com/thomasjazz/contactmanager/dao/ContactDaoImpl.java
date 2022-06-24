package com.thomasjazz.contactmanager.dao;
import java.util.List;

import com.thomasjazz.contactmanager.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.thomasjazz.contactmanager.entity.Contact;
import com.thomasjazz.contactmanager.mapper.ContactRowMapper;

@Repository
public class ContactDaoImpl implements ContactDao
{
    NamedParameterJdbcTemplate template;
    ContactRepository repo;

    @Autowired
    public ContactDaoImpl(NamedParameterJdbcTemplate template, ContactRepository repo)
    {
        this.template = template;
        this.repo = repo;
    }

    @Override
    public List<Contact> findAllContacts()
    {
        return template.query("SELECT * FROM public.contact;", new ContactRowMapper());
    }

    @Override
    public List<Contact> findContactsForUser(int userAccountId)
    {
        final String sql = "SELECT * FROM contact WHERE user_account_id=" + userAccountId;

        return template.query(sql, new ContactRowMapper());
    }

    // TODO: UPDATE THIS TO USE repo.save(contact) INSTEAD OF A QUERY
    @Override
    public Contact insertContact(Contact contact)
    {
        return repo.save(contact);
//        //final String sql = "SELECT func_add_contact AS contact_id FROM func_add_contact(:userAccountId, :firstName, '%s', '%s', '%s', '%s', '%s', '%s')";
//        final String sql = "INSERT INTO contact(user_account_id, first_name, last_name, birthday, mobile_number, home_address, email_address, notes) " +
//            "VALUES(:userAccountId, :firstName, :lastName, :birthday, :mobileNumber, :homeAddress, :emailAddress, :notes)";
//
//        KeyHolder holder = new GeneratedKeyHolder();
//        SqlParameterSource param = new MapSqlParameterSource()
//            .addValue("userAccountId", contact.userAccountId)
//            .addValue("firstName", contact.firstName)
//            .addValue("lastName", contact.lastName)
//            .addValue("birthday", contact.birthday)
//            .addValue("mobileNumber", contact.mobileNumber)
//            .addValue("homeAddress", contact.homeAddress)
//            .addValue("emailAddress", contact.emailAddress)
//            .addValue("notes", contact.notes);
//
//        template.update(sql, param, holder);
    }

    
    @Override
    public Contact updateContact(Contact contact)
    {
//        final String sql = "UPDATE contact " +
//            "SET user_account_id=:userAccountId, first_name=:firstName, last_name=:lastName, birthday=:birthday, " +
//                "mobile_number=:mobileNumber, home_address=:homeAddress, email_address=:emailAddress, notes=:notes " +
//            "WHERE contact_id=:contactId";
//
//        KeyHolder holder = new GeneratedKeyHolder();
//        SqlParameterSource param = new MapSqlParameterSource()
//            .addValue("contactId", contact.contactId)
//            .addValue("userAccountId", contact.userAccountId)
//            .addValue("firstName", contact.firstName)
//            .addValue("lastName", contact.lastName)
//            .addValue("birthday", contact.birthday)
//            .addValue("mobileNumber", contact.mobileNumber)
//            .addValue("homeAddress", contact.homeAddress)
//            .addValue("emailAddress", contact.emailAddress)
//            .addValue("notes", contact.notes);
//
//        template.update(sql, param, holder);
        Contact updated = repo.save(contact);

        return updated;
    }

    // Insert new contact with JPA
    // @Override
    // @Modifying
    // @Query("INSERT INTO contact(user_account_id, first_name, last_name, birthday, mobile_number, home_address, email_address, notes) " +
    //     "VALUES(:userAccountId, :firstName, :lastName, :birthday, :mobileNumber, :homeAddress, :emailAddress, :notes)")
    // public void insertContact
    // (
    //     @Param("userAccountId") String userAccountId,
    //     @Param("firstName") String firstName,
    //     @Param("lastName") String lastName,
    //     @Param("birthday") String birthday,
    //     @Param("mobileNumber") String mobileNumber,
    //     @Param("homeAddress") String homeAddress,
    //     @Param("emailAddress") String emailAddress,
    //     @Param("notes") String notes
    // ){}
}
