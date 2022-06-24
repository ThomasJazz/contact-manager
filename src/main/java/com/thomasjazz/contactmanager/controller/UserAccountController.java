package com.thomasjazz.contactmanager.controller;

import com.thomasjazz.contactmanager.entity.Contact;
import com.thomasjazz.contactmanager.repository.UserAccountRepository;
import com.thomasjazz.contactmanager.service.ContactService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAccountController
{
    @Resource
    ContactService contactService;

    @GetMapping(value="/contacts")
    public List<Contact> getAllContacts(
            @NonNull @NotBlank @RequestParam(value="id") int userAccountId)
    {
        return contactService.findContactsForUser(userAccountId);
    }
}
