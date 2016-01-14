/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.heilwig.rfidbin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Moritz
 */
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String serialNumber;
    private int Kind;


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getKind() {
        return Kind;
    }

    public void setKind(int Kind) {
        this.Kind = Kind;
    }
    
}
