package com.supermailer.mailscheduler;

//import java.util.List;
import java.util.ArrayList;

public class ContactBook 
{
    private final ArrayList<Contact> contacts;//= new ArrayList<Contact>();

    public ContactBook()
    {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact)
    {
        this.contacts.add(contact);
    }

    public void addContact(long contactId, String contactName, String email, String phoneNumber, String companyName)
    {
        this.contacts.add(new Contact(contactId, contactName, email, phoneNumber, companyName));
    }

    public ArrayList<Contact> getContacts()
    {
        return this.contacts;
    }
}
