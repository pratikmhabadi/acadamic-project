/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.myproject.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Pratik
 */
@Entity
public class ContactUS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ContactID;
    @Column(length = 100, name = "NAME")
    private String ContactNAME;
    @Column(length = 99999, name = "Message")
    private String ContactMSG;
    @Column(length = 100, name = "EMAIL")
    private String ContactEMAIL;

    public ContactUS() {
    }

    public int getContactID() {
        return ContactID;
    }

    public void setContactID(int ContactID) {
        this.ContactID = ContactID;
    }

    public String getContactNAME() {
        return ContactNAME;
    }

    public void setContactNAME(String ContactNAME) {
        this.ContactNAME = ContactNAME;
    }

    public String getContactMSG() {
        return ContactMSG;
    }

    public void setContactMSG(String ContactMSG) {
        this.ContactMSG = ContactMSG;
    }

    public String getContactEMAIL() {
        return ContactEMAIL;
    }

    public void setContactEMAIL(String ContactEMAIL) {
        this.ContactEMAIL = ContactEMAIL;
    }

    @Override
    public String toString() {
        return "ContactUS{" + "ContactID=" + ContactID + ", ContactNAME=" + ContactNAME + ", ContactMSG=" + ContactMSG + ", ContactEMAIL=" + ContactEMAIL + '}';
    }
    
    
}
