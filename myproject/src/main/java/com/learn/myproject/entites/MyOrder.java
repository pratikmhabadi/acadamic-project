package com.learn.myproject.entites;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pratik
 */
@Entity
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, name = "ID")
    private int MyOrderID;
    @Column(length = 1000, name = "PRODUCTNAME")
    private String MyOrderProductNAME;
    @Column(length = 10, name = "QUANTITY")
    private int MyOrderProductQTY;
    @Column(length = 10, name = "PRODUCTPRICE")
    private int MyOrderProductPRICE;
    @Column(length = 10, name = "PRODUCTTOTALPRICE")
    private int MyOrderProductTOTALPRICE;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE")
    private Date MyOrderDATE;
    @Column(length = 100, name = "STATUS")
    private String MyOrderSTATUS;
    @Column(length = 10, name = "ORDERNO")
    private int MyOrderNo;
    @Column(length = 10, name = "PRODUCTID")
    private int MyProductID;
    @Column(length = 10, name = "USERID")
    private int MyUserID;

    public MyOrder() {
    }

    public int getMyOrderID() {
        return MyOrderID;
    }

    public void setMyOrderID(int MyOrderID) {
        this.MyOrderID = MyOrderID;
    }

    public String getMyOrderProductNAME() {
        return MyOrderProductNAME;
    }

    public void setMyOrderProductNAME(String MyOrderProductNAME) {
        this.MyOrderProductNAME = MyOrderProductNAME;
    }

    public int getMyOrderProductQTY() {
        return MyOrderProductQTY;
    }

    public void setMyOrderProductQTY(int MyOrderProductQTY) {
        this.MyOrderProductQTY = MyOrderProductQTY;
    }

    public int getMyOrderProductPRICE() {
        return MyOrderProductPRICE;
    }

    public void setMyOrderProductPRICE(int MyOrderProductPRICE) {
        this.MyOrderProductPRICE = MyOrderProductPRICE;
    }

    public int getMyOrderProductTOTALPRICE() {
        return MyOrderProductTOTALPRICE;
    }

    public void setMyOrderProductTOTALPRICE(int MyOrderProductTOTALPRICE) {
        this.MyOrderProductTOTALPRICE = MyOrderProductTOTALPRICE;
    }

    public Date getMyOrderDATE() {
        return MyOrderDATE;
    }

    public void setMyOrderDATE(Date MyOrderDATE) {
        this.MyOrderDATE = MyOrderDATE;
    }

    public String getMyOrderSTATUS() {
        return MyOrderSTATUS;
    }

    public void setMyOrderSTATUS(String MyOrderSTATUS) {
        this.MyOrderSTATUS = MyOrderSTATUS;
    }

    public int getMyOrderNo() {
        return MyOrderNo;
    }

    public void setMyOrderNo(int MyOrderNo) {
        this.MyOrderNo = MyOrderNo;
    }

    public int getMyProductID() {
        return MyProductID;
    }

    public void setMyProductID(int MyProductID) {
        this.MyProductID = MyProductID;
    }

    public int getMyUserID() {
        return MyUserID;
    }

    public void setMyUserID(int MyUserID) {
        this.MyUserID = MyUserID;
    }

    @Override
    public String toString() {
        return "MyOrder{" + "MyOrderID=" + MyOrderID + ", MyOrderProductNAME=" + MyOrderProductNAME + ", MyOrderProductQTY=" + MyOrderProductQTY + ", MyOrderProductPRICE=" + MyOrderProductPRICE + ", MyOrderProductTOTALPRICE=" + MyOrderProductTOTALPRICE + ", MyOrderDATE=" + MyOrderDATE + ", MyOrderSTATUS=" + MyOrderSTATUS + ", MyOrderNo=" + MyOrderNo + ", MyProductID=" + MyProductID + ", MyUserID=" + MyUserID + '}';
    }

}
