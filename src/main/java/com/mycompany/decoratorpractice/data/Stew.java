/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decoratorpractice.data;

import com.mycompany.decoratorpractice.data.Component;

/**
 *
 * @author temdo
 */
public class Stew implements Component{
    
    private String name = "Nordic stew";
    private Integer cost = 50;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
    
    public void addCost(Integer c){
        this.cost += c;
    }


    @Override
    public String getOrderName() {
        return getName();
    }    
    
    @Override
    public Integer getTotalCost(){
        return getCost();
    }
    
}
