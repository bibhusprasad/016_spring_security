package com.bibhu.eazybank.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_messages")
public class Contact {

    @Id
    @Column(name = "contact_id")
    private String contactId;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_email")
    private String contactEmail;
    private String subject;
    private String message;
    @Column(name = "create_dt")
    private Date createDt;

    public Contact() {
    }

    public Contact(final String contactId, final String contactName, final String contactEmail, final String subject, final String message, final Date createDt) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.subject = subject;
        this.message = message;
        this.createDt = createDt;
    }

    public String getContactId() {
        return this.contactId;
    }

    public void setContactId(final String contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(final String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(final String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Date getCreateDt() {
        return this.createDt;
    }

    public void setCreateDt(final Date createDt) {
        this.createDt = createDt;
    }
}
