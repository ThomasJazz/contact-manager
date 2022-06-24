package com.thomasjazz.contactmanager.service;
import java.util.List;
import com.thomasjazz.contactmanager.entity.Contact;

public interface ContactService 
{
    List<Contact> findAllContacts();
    List<Contact> findContactsForUser(int userAccountId);
    Contact insertContact(Contact contact);
    Contact updateContact(Contact contact);
}
