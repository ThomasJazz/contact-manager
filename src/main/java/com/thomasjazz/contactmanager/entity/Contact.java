package com.thomasjazz.contactmanager.entity;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Contact extends Card
{
    @JsonProperty("contact_id")
    @Column(name = "contact_id")
    @Id
    public int contactId;

    @JsonProperty("user_account_id")
    @Column(name = "user_account_id")
    public int userAccountId;



    // @Modifying
    // @Query("INSERT INTO contact(user_account_id, first_name, last_name, birthday, mobile_number, home_address, email_address, notes) " +
    //     "VALUES(:userAccountId, :firstName, :lastName, :birthday, :mobileNumber, :homeAddress, :emailAddress, :notes)")
    // public void insertContact
    // (
    //     @Param("userAccountId") String userAccountId,
    //     @Param("firstName") String firstName,
    //     @Param("lastName") String lastName,
    //     @Param("birthday") String birthday,
    //     @Param("mobileNumber") String mobileNumber,
    //     @Param("homeAddress") String homeAddress,
    //     @Param("emailAddress") String emailAddress,
    //     @Param("notes") String notes
    // ){}
}
