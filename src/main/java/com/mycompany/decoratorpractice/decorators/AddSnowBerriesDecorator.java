/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decoratorpractice.decorators;

/**
 *
 * @author temdo
 */
public class AddSnowBerriesDecorator extends BaseDecorator{
    @Override
    public String getOrderName(){
        return super.getOrderName() + " +SNOW BERRIES";
    }
    
    @Override
    public Integer getTotalCost(){
        return super.getTotalCost() + 6;
    }
}
