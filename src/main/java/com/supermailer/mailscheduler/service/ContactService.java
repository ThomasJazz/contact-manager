package com.supermailer.mailscheduler.service;
import java.util.List;
import com.supermailer.mailscheduler.entity.Contact;

public interface ContactService 
{
    List<Contact> findAll();
    List<Contact> findContactsForUser(int userAccountId);
    void insertContact(Contact contact);
    void updateContact(Contact contact);
}
