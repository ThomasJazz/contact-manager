package com.supermailer.mailscheduler.model;
import java.util.*;
import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

// For JPA mapping to DB
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
import javax.persistence.*;


@Entity
@Table(name="contact")
public class ContactJpa 
{
    @Id
    @Column(name="contact_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public String contactId;

    public String userAccountId;

    public ContactJpa(){}



    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContactJpa other = (ContactJpa) obj;

        if (this.contactId != other.contactId) {
            return false;
        }

        return Objects.equals(this.contactId, other.contactId);
    }
    
}
