/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

/**
 * using integers to represent the symbols
 */
public class Board {
    int[] pattern ={0,0,0,0,0,1,0,0,0,0,0,
    0,0,0,0,2,3,4,0,0,0,0,
    0,0,0,7,3,3,3,2,0,0,0,
    0,0,5,1,1,6,4,4,7,0,0,
    0,6,1,1,4,0,5,4,4,1,0,
    6,2,5,3,0,0,0,7,6,6,7,
    0,4,5,5,3,0,5,6,6,3,0,
    0,0,6,5,7,1,2,2,4,0,0,
    0,0,0,2,7,7,2,1,0,0,0,
    0,0,0,0,5,7,2,0,0,0,0,
    0,0,0,0,0,3,0,0,0,0,0
    };
    
/**
 * converting integers to  symbols
 */
    void printBoard(){
    String temp = "";
    Integer counter = 0;
    Integer num = 11;
    for(int i =0;i< 121; i++){
    switch(pattern[i]){
            case 0: temp="~";
                    break;   
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
    counter++;
    if(counter.equals(num)){
    System.out.println(temp+"  ");
    counter =0;
    }
    else System.out.print(temp+"  ");

    }
    System.out.println();

    }
    
 /**
 * Assgin numbers to represent the positions on the board
 */
    void printPosition(){
    
    System.out.println("Corresponding Positions are: ");
    for(int i =0;i< 121; i++){
    if(pattern[i] != 0){
    if (i<10)
        System.out.print("  "+i+" ");
    else if (i<100)
        System.out.print(" "+i+" ");
    else System.out.print(i+" ");
    }
    else System.out.print("    ");
     
    if((i+1) %11 == 0)
        System.out.println();
    }
    System.out.println();
    }  
  
}
    
    
