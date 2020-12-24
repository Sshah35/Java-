/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telusko;

import java.awt.* ; 


/**
 *
 * @author LIONS
 */
public class Myfirstgui {
    
    public static void main(String[] args) {
        
        new MyFrame(); 
        
    }
    
}

class MyFrame extends Frame 
{
    Label l ;
    Label ll;
    public MyFrame() 
    {
        FlowLayout f = new FlowLayout ; 
        
        setLayout(f);
        l = new  Label ("Hello") ; 
        ll = new Label ("Hi");
        add(l);
        add(ll);
        setVisible(true);
        setSize(500,500);
        
    }
    
    
} 
