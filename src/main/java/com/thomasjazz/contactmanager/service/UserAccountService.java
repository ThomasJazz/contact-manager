package com.thomasjazz.contactmanager.service;

import com.thomasjazz.contactmanager.entity.Contact;
import com.thomasjazz.contactmanager.entity.UserAccount;

import java.util.List;


public interface UserAccountService
{
    List<UserAccount> findAllUsers();
    List<Contact> findAllUserContacts(int id);
}
