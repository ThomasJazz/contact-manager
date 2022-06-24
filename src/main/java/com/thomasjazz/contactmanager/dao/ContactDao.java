package com.thomasjazz.contactmanager.dao;

import java.util.List;
import com.thomasjazz.contactmanager.entity.Contact;

// https://dzone.com/articles/bounty-spring-boot-and-postgresql-database
// DAO stands for data access object
public interface ContactDao 
{
    // JDBC methods
    List<Contact> findAll();
    List<Contact> findContactsForUser(int userAccountId);
    void insertContact(Contact contact);
    void updateContact(Contact contact);
    
    // JPA methods
    // void insertContact
    // (
    //     String userAccountId,
    //     String firstName,
    //     String lastName,
    //     String birthday,
    //     String emailAddress,
    //     String mobileNumber,
    //     String homeAddress,
    //     String notes
    // );

    // @Modifying
    // @Query("INSERT INTO contact(user_account_id, first_name, last_name, birthday, mobile_number, home_address, email_address, notes) " +
    //     "VALUES(:userAccountId, :firstName, :lastName, :birthday, :mobileNumber, :homeAddress, :emailAddress, :notes)")
    // void insertContact
    // (
    //     @Param("userAccountId") String userAccountId,
    //     @Param("firstName") String firstName,
    //     @Param("lastName") String lastName,
    //     @Param("birthday") String birthday,
    //     @Param("mobileNumber") String mobileNumber,
    //     @Param("homeAddress") String homeAddress,
    //     @Param("emailAddress") String emailAddress,
    //     @Param("notes") String notes
    // );
    
    // updates should only affect a single Contact record so we probably don't need to know the number of affected records
    //void executeUpdateContact(Contact contact); 
}
