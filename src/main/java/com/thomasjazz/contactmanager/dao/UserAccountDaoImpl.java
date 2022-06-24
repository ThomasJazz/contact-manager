package com.thomasjazz.contactmanager.dao;

import com.thomasjazz.contactmanager.entity.Contact;
import com.thomasjazz.contactmanager.entity.UserAccount;
import com.thomasjazz.contactmanager.mapper.ContactRowMapper;
import com.thomasjazz.contactmanager.repository.ContactRepository;
import com.thomasjazz.contactmanager.repository.UserAccountRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAccountDaoImpl implements UserAccountDao
{
    NamedParameterJdbcTemplate template;
    UserAccountRepository userRepo;
    ContactRepository contactRepo;

    @Autowired
    public UserAccountDaoImpl(NamedParameterJdbcTemplate template,
                              UserAccountRepository userRepo,
                              ContactRepository contactRepo)
    {
        this.template = template;
        this.userRepo = userRepo;
        this.contactRepo = contactRepo;
    }

    /**
     * @param userAccountId
     * @return
     */
    @Override
    public List<Contact> findAllUserContacts(int userAccountId) {
        final String sql = "SELECT * FROM contact WHERE user_account_id=" + userAccountId;

        return template.query(sql, new ContactRowMapper());
    }

    /**
     * @param contact
     */
    @Override
    public void insertContact(Contact contact)
    {
        contactRepo.save(contact);
    }

    /**
     * @param contact
     */
    @Override
    @Modifying
    @Query("update contact c set ")
    public void updateUserContact(Contact contact)
    {
        contactRepo.save(contact);
    }
}
