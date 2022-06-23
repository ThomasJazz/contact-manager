package com.supermailer.mailscheduler.controller;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermailer.mailscheduler.service.ContactService;
import com.supermailer.mailscheduler.entity.Contact;

@RestController
@RequestMapping("/contact")
public class ContactController 
{
    @Resource
    ContactService contactService;

    @GetMapping(value="/list-all")
    public List<Contact> getAllContacts()
    {
        System.out.println("Executed getAllContacts");
        return contactService.findAll();
    }

    @PostMapping(value="/add")
    public void addContact(@RequestBody Contact contact)
    {
        contactService.insertContact(contact);
    }
}
