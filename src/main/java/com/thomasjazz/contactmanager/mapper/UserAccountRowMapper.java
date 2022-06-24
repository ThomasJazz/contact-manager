package com.thomasjazz.contactmanager.mapper;

import com.thomasjazz.contactmanager.entity.UserAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountRowMapper implements RowMapper<UserAccount>
{
    @Override
    public UserAccount mapRow(ResultSet rs, int arg1) throws SQLException
    {
        UserAccount acc = new UserAccount();
        acc.userAccountId = rs.getInt("user_account_id");
        acc.firstName = rs.getString("first_name");
        acc.lastName = rs.getString("last_name");
        acc.birthday = rs.getDate("birthday");
        acc.mobileNumber = rs.getString("mobile_number");
        acc.homeAddress = rs.getString("home_address");
        acc.emailAddress = rs.getString("email_address");
        acc.notes = rs.getString("notes");
        acc.createDateTime = rs.getString("create_date_time");

        return acc;
    }
}
