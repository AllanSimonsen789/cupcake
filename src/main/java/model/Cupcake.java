/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author THOMA
 */
public class Cupcake {
    
    double price;
    Bottom bot;
    Top top;
    
    
    public Cupcake(Bottom bot, Top top){
        this.price=bot.getPrice()+top.getPrice();
        this.bot=bot;
        this.top=top;
        
        
    }
    
}
