package com.thomasjazz.contactmanager.entity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact extends Card
{
    @JsonProperty("user_account_id")
    public int userAccountId;

    @JsonProperty("contact_id")
    public int contactId;

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
