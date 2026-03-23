/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decoratorpractice.UI;

import com.mycompany.decoratorpractice.data.Component;
import com.mycompany.decoratorpractice.data.Order;
import com.mycompany.decoratorpractice.data.Stew;
import com.mycompany.decoratorpractice.decorators.AddExtraVenisonDecorator;
import com.mycompany.decoratorpractice.decorators.AddFireSauseDecorator;
import com.mycompany.decoratorpractice.decorators.AddNordicBreadDecorator;
import com.mycompany.decoratorpractice.decorators.AddSnowBerriesDecorator;
import com.mycompany.decoratorpractice.decorators.BaseDecorator;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author temdo
 */
public class ClientUI extends JFrame{
    
    int maxSelected = 3;
    
    ArrayList<Order> orders = new ArrayList();
    
    public ClientUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 1, 10, 10));
       
        ArrayList<JCheckBox> checkboxes = new ArrayList();
        
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentSelection = 0;
                for(JCheckBox cb : checkboxes){
                    if (cb.isSelected()){
                        currentSelection += 1;
                    }
                }
                if (currentSelection > maxSelected){
                    System.out.println("You cannot chose more than 3 options");
                    JCheckBox source = (JCheckBox) e.getSource();
                    source.setSelected(false);
                }
            }
        };
        JTextArea textArea = new JTextArea();
        textArea.setRows(10);
        textArea.setEditable(false);
        
        JCheckBox fireSauseCheckBox = new JCheckBox("Add fire sauce + 10");
        JCheckBox extraVenisonCheckBox = new JCheckBox("Add extra venison (double) + 20");
        JCheckBox nordicBreadCheckBox = new JCheckBox("Add nordic bread + 7");
        JCheckBox snowBerriesCheckBox = new JCheckBox("Add snow berries + 6");
        
        JButton commitOrderButton = new JButton("Commit order");
        JButton showHistoryButton = new JButton("Show order history");
        
        checkboxes.add(fireSauseCheckBox);
        checkboxes.add(extraVenisonCheckBox);
        checkboxes.add(nordicBreadCheckBox);
        checkboxes.add(snowBerriesCheckBox);
        
        for(JCheckBox cb : checkboxes){
            cb.addActionListener(al);
        }
        
        commitOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component stew = new Stew();
                
                BaseDecorator afsd = new AddFireSauseDecorator();
                BaseDecorator aevd = new AddExtraVenisonDecorator();
                BaseDecorator anbd = new AddNordicBreadDecorator();
                BaseDecorator asbd = new AddSnowBerriesDecorator();

                ArrayList<BaseDecorator> ds = new ArrayList();
                ds.add(afsd);
                ds.add(aevd);
                ds.add(anbd);
                ds.add(asbd);
                
                for (int i = 0; i < checkboxes.size(); i++) {
                    if(checkboxes.get(i).isSelected()){
                        ds.get(i).addDecorator(stew);
                        stew = ds.get(i);
                    }
                }

                Order o = new Order(LocalTime.now().toString(), stew.getOrderName(), stew.getTotalCost());
                orders.add(o);
                System.out.println(o.getInfo());
                
            }
        });
        
        showHistoryButton.addActionListener(new ActionListener(){
        
            
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (String s : createOrdersHistoryList()) {
                    textArea.append(s + "\n");
                }
                
            }

            private Iterable<String> createOrdersHistoryList() {
                ArrayList<String> tmp = new ArrayList();
                for(Order order: orders){
                    tmp.add(order.getInfo());
                }
                
                return tmp;
            }
        });

        this.add(fireSauseCheckBox);
        this.add(extraVenisonCheckBox);
        this.add(nordicBreadCheckBox);
        this.add(snowBerriesCheckBox);
        this.add(commitOrderButton);
        this.add(showHistoryButton);
        this.add(new JScrollPane(textArea));
   
        this.setVisible(true);
        
    }
}
