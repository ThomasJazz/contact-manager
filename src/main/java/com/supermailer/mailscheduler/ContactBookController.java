package com.supermailer.mailscheduler;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;

//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;

@RestController
public class ContactBookController 
{
    private final ContactBook contactBook = new ContactBook();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/add-contact")
    public ContactBook contactBook(
        @RequestParam(value = "contactName", defaultValue = "") String contactName,
        @RequestParam(value = "email", defaultValue = "") String email,
        @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
        @RequestParam(value = "companyName", defaultValue = "") String companyName
    )
    {
        if (contactName.isEmpty())
        {
            throw new ContactNameEmptyException();
        }

        this.contactBook.addContact(counter.incrementAndGet(), contactName, email, phoneNumber, companyName);
        return this.contactBook;
    }

    // https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.6
    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "contactName is empty")
    public class ContactNameEmptyException extends RuntimeException {}
    //@ExceptionHandler({})
}
