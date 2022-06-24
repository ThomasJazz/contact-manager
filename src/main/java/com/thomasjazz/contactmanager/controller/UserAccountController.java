package com.thomasjazz.contactmanager.controller;

import com.thomasjazz.contactmanager.dao.ContactDao;
import com.thomasjazz.contactmanager.entity.Contact;
import com.thomasjazz.contactmanager.entity.UserAccount;
import com.thomasjazz.contactmanager.repository.UserAccountRepository;
import com.thomasjazz.contactmanager.service.ContactService;
import com.thomasjazz.contactmanager.service.UserAccountService;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAccountController
{
    @Resource
    ContactService contactService;

    @Resource
    UserAccountService userService;

    @GetMapping(value="/list-all")
    public List<UserAccount> getAllUsers()
    {
        System.out.println("Executed getAllContacts");
        return userService.findAllUsers();
    }

    @GetMapping(value="/contacts")
    public List<Contact> getAllContacts(
            @NonNull @NotBlank @RequestParam(value="id") int userAccountId)
    {
        return contactService.findContactsForUser(userAccountId);
    }

    @PostMapping(value="/contacts/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Contact insertContact(@RequestBody Contact contact)
    {
        contactService.insertContact(contact);
        return contact;
    }
}
