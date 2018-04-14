/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Gene
 */
public class Deck {
    private ArrayList<Dominos> dominos;
/**
* Initialize the deck
* setting 28 dominos onto the deck
* each domino represents two integers, which can be converted to symbols
 */  
    public Deck(){
    dominos= new ArrayList<>();

    for (int i = 1; i<8 ; i++){
        for(int j=i ;j<8; j++){
        dominos.add(new Dominos(i,j));
        }
    }
    }
  /**
* shuffle the whole deck
 */   
    public void shuffle(){
    Collections.shuffle(dominos);
    
    }
/**
* getter for the specific domino 
*@param index of the domino list 
 */    
    public Dominos getDeck(int num){
    Dominos result;
    result = dominos.get(num);
    return result;
    }
}
    
   
