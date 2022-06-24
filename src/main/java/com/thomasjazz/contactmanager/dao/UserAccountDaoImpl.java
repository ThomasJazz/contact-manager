package com.thomasjazz.contactmanager.dao;

import com.thomasjazz.contactmanager.entity.Contact;
import com.thomasjazz.contactmanager.mapper.ContactRowMapper;
import com.thomasjazz.contactmanager.repository.UserAccountRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class UserAccountDaoImpl implements UserAccountDao
{
    NamedParameterJdbcTemplate template;
    UserAccountRepository repo;

    public UserAccountDaoImpl(NamedParameterJdbcTemplate template)
    {
        this.template = template;
        this.repo = BeanFactory.getBean(UserAccountRepository.class);
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
    public void insertUserContact(Contact contact) {

    }

    /**
     * @param contact
     */
    @Override
    @Modifying
    @Query("update contact c set ")
    public void updateUserContact(Contact contact) {

    }
}
