package com.thomasjazz.contactmanager.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAccount extends Card
{
    @JsonProperty("user_account_id")
    public String userAccountId = null;
}
