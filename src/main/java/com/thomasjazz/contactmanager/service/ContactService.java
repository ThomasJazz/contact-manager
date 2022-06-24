package com.thomasjazz.contactmanager.service;
import java.util.List;
import com.thomasjazz.contactmanager.entity.Contact;

public interface ContactService 
{
    List<Contact> findAll();
    List<Contact> findContactsForUser(int userAccountId);
    void insertContact(Contact contact);
    void updateContact(Contact contact);
}
