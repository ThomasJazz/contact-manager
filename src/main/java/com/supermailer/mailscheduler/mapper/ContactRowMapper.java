package com.supermailer.mailscheduler.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.supermailer.mailscheduler.entity.Contact;

public class ContactRowMapper implements RowMapper<Contact>
{
    @Override
    public Contact mapRow(ResultSet rs, int arg1) throws SQLException
    {
        Contact cont = new Contact();
        cont.contactId = rs.getInt("contact_id");
        cont.userAccountId = rs.getInt("user_account_id");
        cont.firstName = rs.getString("first_name");
        cont.lastName = rs.getString("last_name");
        cont.birthday = rs.getDate("birthday");
        cont.mobileNumber = rs.getString("mobile_number");
        cont.homeAddress = rs.getString("home_address");
        cont.emailAddress = rs.getString("email_address");
        cont.notes = rs.getString("notes");
        cont.createDateTime = rs.getString("create_date_time");

        return cont;
    }
}
