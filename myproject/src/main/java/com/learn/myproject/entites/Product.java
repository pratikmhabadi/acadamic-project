package com.learn.myproject.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ProductID;
    @Column(length = 100, name = "NAME")
    private String ProductNAME;
    @Column(length = 99999, name = "DESCRIPTION")
    private String ProductDESCRIPTION;
    @Column(name = "PRICE")
    private int ProductPRICE;
    @Column(name = "DISCOUNT")
    private int ProductDISCOUNT;
    @Column(length = 100, name = "STATUS")
    private String ProductSTATUS;
    @Column(length = 999999999, name = "IMG1")
    private String ProductIMG1;
    @Column(length = 999999999, name = "IMG2")
    private String ProductIMG2;
    @Column(length = 999999999, name = "IMG3")
    private String ProductIMG3;
    @Column(length = 999999999, name = "IMG4")
    private String ProductIMG4;
    @Column(length = 100, name = "BADGE")
    private String ProductBADGE;
    @Column(length = 100, name = "TYPE")
    private String ProductTYPE;

    @ManyToOne
    private Category Category;

    @ManyToOne
    private User User;

  

    public Product() {
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductNAME() {
        return ProductNAME;
    }

    public void setProductNAME(String ProductNAME) {
        this.ProductNAME = ProductNAME;
    }

    public String getProductDESCRIPTION() {
        return ProductDESCRIPTION;
    }

    public void setProductDESCRIPTION(String ProductDESCRIPTION) {
        this.ProductDESCRIPTION = ProductDESCRIPTION;
    }

    public int getProductPRICE() {
        return ProductPRICE;
    }

    public void setProductPRICE(int ProductPRICE) {
        this.ProductPRICE = ProductPRICE;
    }

    public int getProductDISCOUNT() {
        return ProductDISCOUNT;
    }

    public void setProductDISCOUNT(int ProductDISCOUNT) {
        this.ProductDISCOUNT = ProductDISCOUNT;
    }

    public String getProductSTATUS() {
        return ProductSTATUS;
    }

    public void setProductSTATUS(String ProductSTATUS) {
        this.ProductSTATUS = ProductSTATUS;
    }

    public String getProductIMG1() {
        return ProductIMG1;
    }

    public void setProductIMG1(String ProductIMG1) {
        this.ProductIMG1 = ProductIMG1;
    }

    public String getProductIMG2() {
        return ProductIMG2;
    }

    public void setProductIMG2(String ProductIMG2) {
        this.ProductIMG2 = ProductIMG2;
    }

    public String getProductIMG3() {
        return ProductIMG3;
    }

    public void setProductIMG3(String ProductIMG3) {
        this.ProductIMG3 = ProductIMG3;
    }

    public String getProductIMG4() {
        return ProductIMG4;
    }

    public void setProductIMG4(String ProductIMG4) {
        this.ProductIMG4 = ProductIMG4;
    }

    public String getProductBADGE() {
        return ProductBADGE;
    }

    public void setProductBADGE(String ProductBADGE) {
        this.ProductBADGE = ProductBADGE;
    }

    public String getProductTYPE() {
        return ProductTYPE;
    }

    public void setProductTYPE(String ProductTYPE) {
        this.ProductTYPE = ProductTYPE;
    }

    public Category getCategory() {
        return Category;
    }

    public void setCategory(Category Category) {
        this.Category = Category;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    @Override
    public String toString() {
        return "Product{" + "ProductID=" + ProductID + ", ProductNAME=" + ProductNAME + ", ProductDESCRIPTION=" + ProductDESCRIPTION + ", ProductPRICE=" + ProductPRICE + ", ProductDISCOUNT=" + ProductDISCOUNT + ", ProductSTATUS=" + ProductSTATUS + ", ProductIMG1=" + ProductIMG1 + ", ProductIMG2=" + ProductIMG2 + ", ProductIMG3=" + ProductIMG3 + ", ProductIMG4=" + ProductIMG4 + ", ProductBADGE=" + ProductBADGE + ", ProductTYPE=" + ProductTYPE + ", Category=" + Category + ", User=" + User + '}';
    }

  

     public int getPriceDiscount()
    {
        int d=(int) ((this.getProductDISCOUNT()/100.0)*this.getProductPRICE());
        return this.getProductPRICE()-d;
    }
}
