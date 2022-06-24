package com.thomasjazz.contactmanager.dao;
import java.util.List;

import com.thomasjazz.contactmanager.entity.Contact;
import com.thomasjazz.contactmanager.entity.UserAccount;


public interface UserAccountDao
{
    List<UserAccount> findAllUserAccounts();

    List<Contact> findAllUserContacts(int userAccountId);
    void insertContact(Contact contact);
    void updateUserContact(Contact contact);
}
