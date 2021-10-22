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
public class Category {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column( name="ID")
     private int CategoryID;
     @Column( length=100, name="NAME")
     private String CategoryNAME;
     @Column(length  =99999, name="DESCRIPTION")
     private String CategoryDESCRIPTION;
     @Column (length =1000000000 ,name="PHOTO")
     private String CategoryPHOTO;
     
    @OneToMany(mappedBy = "Category")
    private List<Product> Products = new ArrayList<>();

    public Category(int CategoryID, String CategoryNAME, String CategoryDESCRIPTION, String CategoryPHOTO) {
        this.CategoryID = CategoryID;
        this.CategoryNAME = CategoryNAME;
        this.CategoryDESCRIPTION = CategoryDESCRIPTION;
        this.CategoryPHOTO = CategoryPHOTO;
    }

    public Category(String CategoryNAME, String CategoryDESCRIPTION, String CategoryPHOTO) {
        this.CategoryNAME = CategoryNAME;
        this.CategoryDESCRIPTION = CategoryDESCRIPTION;
        this.CategoryPHOTO = CategoryPHOTO;
    }

    public Category() {
    }
    
    
    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryNAME() {
        return CategoryNAME;
    }

    public void setCategoryNAME(String CategoryNAME) {
        this.CategoryNAME = CategoryNAME;
    }

    public String getCategoryDESCRIPTION() {
        return CategoryDESCRIPTION;
    }

    public void setCategoryDESCRIPTION(String CategoryDESCRIPTION) {
        this.CategoryDESCRIPTION = CategoryDESCRIPTION;
    }

    public String getCategoryPHOTO() {
        return CategoryPHOTO;
    }

    public void setCategoryPHOTO(String CategoryPHOTO) {
        this.CategoryPHOTO = CategoryPHOTO;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> Products) {
        this.Products = Products;
    }

    @Override
    public String toString() {
        return "Category{" + "CategoryID=" + CategoryID + ", CategoryNAME=" + CategoryNAME + ", CategoryDESCRIPTION=" + CategoryDESCRIPTION + ", CategoryPHOTO=" + CategoryPHOTO + ", Products=" + Products + '}';
    }

   
}
