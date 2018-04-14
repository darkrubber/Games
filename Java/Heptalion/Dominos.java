/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;


/**
 *
 * @author Gene
 */
public class Dominos{

private int _value;
private int _value2;
/**
* Initialize each domino
* @param two integers from Deck's constructor
 */ 
public Dominos(int value, int value2){

_value =value;
_value2 = value2;
        
}

int getValue(){
return _value;
}

int getValue2(){
return _value2;
}
/**
* convert the integer to the corresponding symbol
 */ 
@Override
public String toString(){
    String temp = null;
    String temp2 =null;
    
    switch(_value){
 
            case 1: temp="\u25CF";
                    break;   
            case 2: temp="\u2601";
                    break;   
            case 3: temp="\u25A0";
                    break;   
            case 4: temp="\u2609";
                    break;   
            case 5: temp="\u271A";
                    break;   
            case 6: temp="\u25C7";
                    break;   
            case 7: temp="\u2716";
                    break;   
    }
    switch(_value2){  
            case 1: temp2="\u25CF";
                    break;   
            case 2: temp2="\u2601";
                    break;   
            case 3: temp2="\u25A0";
                    break;   
            case 4: temp2="\u2609";
                    break;   
            case 5: temp2="\u271A";
                    break;   
            case 6: temp2="\u25C7";
                    break;   
            case 7: temp2="\u2716";
                    break;   
    }
        return temp+ temp2+" ";
}

}
