package com.thomasjazz.contactmanager.service;

import com.thomasjazz.contactmanager.dao.ContactDao;
import org.springframework.stereotype.Component;
import com.thomasjazz.contactmanager.entity.Contact;
import javax.annotation.Resource;
import java.util.List;

@Component
public class ContactServiceImpl implements ContactService 
{
    @Resource
    ContactDao contactDao;

    @Override
    public List<Contact> findAllContacts()
    {
        return contactDao.findAllContacts();
    }

    @Override
    public List<Contact> findContactsForUser(int userAccountId)
    {
        return contactDao.findContactsForUser(userAccountId);
    }

    @Override
    public void insertContact(Contact contact)
    {
        contactDao.insertContact(contact);
    }

    @Override
    public void updateContact(Contact contact)
    {
        contactDao.updateContact(contact);
    }
}
