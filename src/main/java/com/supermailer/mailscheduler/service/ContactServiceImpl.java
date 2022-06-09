package com.supermailer.mailscheduler.service;

import org.springframework.stereotype.Component;
import com.supermailer.mailscheduler.dao.ContactDao;
import com.supermailer.mailscheduler.entity.Contact;
import javax.annotation.Resource;
import java.util.List;

@Component
public class ContactServiceImpl implements ContactService 
{
    @Resource
    ContactDao contactDao;

    @Override
    public List<Contact> findAll()
    {
        return contactDao.findAll();
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
