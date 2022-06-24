package com.thomasjazz.contactmanager.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccount extends Card
{
    @JsonProperty("user_account_id")
    @Column(name = "user_account_id")
    @Id
    public int userAccountId;

    @JsonProperty("contact_id")
    @Column(name = "contact_id")
    public int contactId;
}
