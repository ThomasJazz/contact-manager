package com.thomasjazz.contactmanager.service;

import com.thomasjazz.contactmanager.dao.UserAccountDao;
import com.thomasjazz.contactmanager.entity.Contact;
import com.thomasjazz.contactmanager.entity.UserAccount;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component
@Service
public class UserAccountServiceImpl implements UserAccountService
{
    @Resource
    UserAccountDao userAccountDao;

    @Override
    public List<Contact> findAllUserContacts(int id)
    {
        return userAccountDao.findAllUserContacts(id);
    }
}
