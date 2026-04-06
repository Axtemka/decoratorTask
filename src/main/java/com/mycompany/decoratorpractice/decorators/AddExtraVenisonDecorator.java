/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decoratorpractice.decorators;

/**
 *
 * @author temdo
 */
public class AddExtraVenisonDecorator extends BaseDecorator{
    
    @Override
    public String getOrderName(){
        return super.getOrderName() + " +DOUBLE VENISON";
    }
    
    @Override
    public Integer getTotalCost(){
        return super.getTotalCost() + 20;
    }
    
}
