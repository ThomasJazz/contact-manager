package com.supermailer.mailscheduler;

public class Contact 
{
    public final long contactId;
    public String contactName;
    public String email;
    public String phoneNumber;
    public String companyName;

    public Contact(long contactId, String contactName, String email, String phoneNumber, String companyName)
    {
        this.contactId = contactId;
        this.contactName = contactName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
    }
}
