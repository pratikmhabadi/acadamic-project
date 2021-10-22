/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.myproject.entites;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Pratik
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, name = "ID")
    private int UserID;
    @Column(length = 50, name = "FIRSTNAME")
    private String UserFNAME;
    @Column(length = 50, name = "LASTNAME")
    private String UserLNAME;   
    @Column(length = 12, name = "CONTACT")
    private String UserCONTACT;
    @Column(length = 1500, name = "ADDRESS")
    private String UserADDRESS;
    @Column(length = 1500, name = "SHIPPING")
    private String UserSHIPPNG;
    @Column(length = 50, name = "STATE")
    private String UserSTATE;
    @Column(length = 50, name = "CITY")
    private String UserCITY;
    @Column(length = 10, name = "ZIP")
    private String UserZIP;
    @Column(length = 100, name = "EMAIL")
    private String UserEMAIL;
    @Column(length = 100, name = "PASSWORD")
    private String UserPASSWORD;  
    @Column(length = 10, name = "CODE")
    private String UserCODE;
    @Column(length = 50, name = "TYPE")
    private String UserTYPE;
    @Column(length = 999999999, name = "PHOTO")
    private String UserPHOTO;

   
//    @OneToMany(mappedBy = "User")
//    private List<Product> Products = new ArrayList<>();

    public User() {
    }    

    public User(String UserEMAIL, String UserPASSWORD, String UserCODE) {
        this.UserEMAIL = UserEMAIL;
        this.UserPASSWORD = UserPASSWORD;
        this.UserCODE = UserCODE;
    }

    public User(String UserEMAIL, String UserCODE) {
        this.UserEMAIL = UserEMAIL;
        this.UserCODE = UserCODE;
    }

    public int getUserID() {
        return UserID;
    }
    

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUserFNAME() {
        return UserFNAME;
    }

    public void setUserFNAME(String UserFNAME) {
        this.UserFNAME = UserFNAME;
    }

    public String getUserLNAME() {
        return UserLNAME;
    }

    public void setUserLNAME(String UserLNAME) {
        this.UserLNAME = UserLNAME;
    }

    public String getUserCONTACT() {
        return UserCONTACT;
    }

    public void setUserCONTACT(String UserCONTACT) {
        this.UserCONTACT = UserCONTACT;
    }

    public String getUserADDRESS() {
        return UserADDRESS;
    }

    public void setUserADDRESS(String UserADDRESS) {
        this.UserADDRESS = UserADDRESS;
    }

    public String getUserSHIPPNG() {
        return UserSHIPPNG;
    }

    public void setUserSHIPPNG(String UserSHIPPNG) {
        this.UserSHIPPNG = UserSHIPPNG;
    }

    public String getUserSTATE() {
        return UserSTATE;
    }

    public void setUserSTATE(String UserSTATE) {
        this.UserSTATE = UserSTATE;
    }

    public String getUserCITY() {
        return UserCITY;
    }

    public void setUserCITY(String UserCITY) {
        this.UserCITY = UserCITY;
    }

    public String getUserZIP() {
        return UserZIP;
    }

    public void setUserZIP(String UserZIP) {
        this.UserZIP = UserZIP;
    }

    public String getUserEMAIL() {
        return UserEMAIL;
    }

    public void setUserEMAIL(String UserEMAIL) {
        this.UserEMAIL = UserEMAIL;
    }

    public String getUserPASSWORD() {
        return UserPASSWORD;
    }

    public void setUserPASSWORD(String UserPASSWORD) {
        this.UserPASSWORD = UserPASSWORD;
    }

    public String getUserCODE() {
        return UserCODE;
    }

    public void setUserCODE(String UserCODE) {
        this.UserCODE = UserCODE;
    }

    public String getUserTYPE() {
        return UserTYPE;
    }

    public void setUserTYPE(String UserTYPE) {
        this.UserTYPE = UserTYPE;
    }

    public String getUserPHOTO() {
        return UserPHOTO;
    }

    public void setUserPHOTO(String UserPHOTO) {
        this.UserPHOTO = UserPHOTO;
    }

//    public List<Product> getProducts() {
//        return Products;
//    }
//
//    public void setProducts(List<Product> Products) {
//        this.Products = Products;
//    }

    @Override
    public String toString() {
        return "User{" + "UserID=" + UserID + ", UserFNAME=" + UserFNAME + ", UserLNAME=" + UserLNAME + ", UserCONTACT=" + UserCONTACT + ", UserADDRESS=" + UserADDRESS + ", UserSHIPPNG=" + UserSHIPPNG + ", UserSTATE=" + UserSTATE + ", UserCITY=" + UserCITY + ", UserZIP=" + UserZIP + ", UserEMAIL=" + UserEMAIL + ", UserPASSWORD=" + UserPASSWORD + ", UserCODE=" + UserCODE + ", UserTYPE=" + UserTYPE + ", UserPHOTO=" + UserPHOTO + '}';
    }

}