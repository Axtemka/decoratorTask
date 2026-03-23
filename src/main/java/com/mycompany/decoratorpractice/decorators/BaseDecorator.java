/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decoratorpractice.decorators;

import com.mycompany.decoratorpractice.data.Component;

/**
 *
 * @author temdo
 */
abstract public class BaseDecorator implements Component{
    protected Component wrapper;
    
    public void addDecorator(Component c){
        wrapper = c;
    }
    
    @Override
    public String getOrderName(){
        return wrapper.getOrderName();
    }
    
    @Override
    public Integer getTotalCost(){
        return wrapper.getTotalCost();
    }
    
}
