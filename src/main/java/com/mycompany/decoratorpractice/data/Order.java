/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decoratorpractice.data;

/**
 *
 * @author temdo
 */
public class Order {
    private String time;
    private String fullOrder;
    private Integer totalCost;

    public Order(String time, String fullOrder, Integer totalCost) {
        this.time = time;
        this.fullOrder = fullOrder;
        this.totalCost = totalCost;
    }
    
    public String getInfo(){
        return time + " : " + fullOrder + " | " + totalCost;
    }
}
