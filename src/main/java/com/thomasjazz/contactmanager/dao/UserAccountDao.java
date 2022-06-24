package com.thomasjazz.contactmanager.dao;
import java.util.List;

import com.thomasjazz.contactmanager.entity.Contact;

public interface UserAccountDao
{
    List<Contact> findAllUserContacts(int userAccountId);
    void insertUserContact(Contact contact);
    void updateUserContact(Contact contact);
}
