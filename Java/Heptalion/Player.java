/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author Gene
 */
public class Player {
    
private String _name;
private ArrayList<Dominos> pieces;


/**
* Initialize fields of Dominos for the player
* @param number of the player(1 or 2)
 */  
public Player(int num){
pieces = new ArrayList<>();
setName(num);
}
/**
* setter for _name
* ask user for the name
 */
void setName(int num){
System.out.print("Enter Name for the Player "+num+": " );
Scanner sc = new Scanner(System.in);
_name = sc.next();
}
/**
* getter for _name
 */
String getName(){
return _name;
}
/**
* add dominos to the player's deck
 */
void setDom(Dominos domino){
pieces.add(domino);
}

int getArraySize(){
    return pieces.size();
}
Dominos getDom(int index){
return pieces.get(index);
}

void removeDom(int index){
pieces.remove(index);
}
/**
* check to see if the deck is empty
 */
boolean checkWin(){
if (pieces.isEmpty())
    return true;
return false;
}

void printDeck(){
    int num =0;
    for (Dominos domino :pieces)
        System.out.print(++num+": "+domino+" ");
    System.out.print("\n");
}

@Override
public String toString(){
    return _name;

}
    
}
