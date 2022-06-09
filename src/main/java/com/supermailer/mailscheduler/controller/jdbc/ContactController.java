package com.supermailer.mailscheduler.controller.jdbc;

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
@RequestMapping("/jdbc-app")
public class ContactController 
{
    @Resource
    ContactService contactService;

    @GetMapping(value="/contact-list")
    public List<Contact> getAllContacts()
    {
        return contactService.findAll();
    }

    @PostMapping(value="/add-contact")
    public void addContact(@RequestBody Contact contact)
    {
        contactService.insertContact(contact);
    }
}
