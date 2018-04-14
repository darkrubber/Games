/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gene
 */
public class Game {
// Constructing Board, Players and Deck 
Board board = new Board();
Player player1 = new Player(1);
Player player2 = new Player(2);
Deck deck = new Deck();
Scanner sc = new Scanner(System.in);

// Intro
void printIntro(){
    System.out.println("Welcome to Heptalion !\n");
    System.out.println("Game has been started!!\n");
}
 
/**
* Game Starts 
 */
void playGame(){

printIntro();
deck.shuffle();

for (int i=0; i<14; i++){   
player1.setDom(deck.getDeck(i));
player2.setDom(deck.getDeck(27-i));
}
move();
}
/**
* Player's inputs
* 3 attempts or no match on the deck will cause a loss
 */      
void move(){
    
Player player= player1;   
int location1 = 0;
int location2 =0;
int index =0;

boolean next =false;
boolean first =false;
boolean second = false;
boolean done =false;

while(!checkLoss(player)&& !done){

int attempt =3; 

board.printBoard();
board.printPosition();

do{
System.out.println("This is the turn for "+ player);
player.printDeck();
try{
System.out.println("Input Your Choice:");
index = (sc.nextInt())-1;
System.out.println("Input the Locations On Which the Domino Is Put :");
location1 = sc.nextInt();
System.out.println("And ");
location2 = sc.nextInt();
}
catch(Exception ex){
System.out.println("Error:Wrong Input");
}
attempt--;

if(player.getDom(index).getValue()==board.pattern[location1]||player.getDom(index).getValue() ==board.pattern[location2])
    first = true;
if (player.getDom(index).getValue2()==board.pattern[location2]||player.getDom(index).getValue2() ==board.pattern[location1] )
    second = true;

if(first && second){
    player.removeDom(index);
    board.pattern[location1] = 0;
    board.pattern[location2] = 0;
    attempt =0;
}
else if(attempt>0)
    System.out.println("Invalid move! You have "+ attempt+" attempts. Try again." );
else {System.out.println("Run out of Attempts!");
        done= true;
                }

}while(attempt>0);

System.out.println("=================================================");

next =!next;
if(!next)
    player = player1;
else player = player2;
if( player.checkWin())
    done = true;

if(done){
winner(player.getName());
}
if(checkLoss(player))
    System.out.println("Player "+player.getName()+" Lost ...." );
  }
}
/**
* Check to see if there is any valid moves for the player
 */  

boolean checkLoss(Player player){

for(int i=0; i<player.getArraySize();i++ ){
    for(int j=0; j<121; j++){
        if(player.getDom(i).getValue()==board.pattern[j]){
            if((j-11)>=0 && player.getDom(i).getValue2() ==board.pattern[j-11])
               return false;
            else if((j-1)>=0 && player.getDom(i).getValue2() ==board.pattern[j-1])
                return false;
            else if((j+11)<121 && player.getDom(i).getValue2() ==board.pattern[j+11])
                return false;
            else if(j+1<121 && player.getDom(i).getValue2() ==board.pattern[j+1]){
                return false;
            }
        }
            
        else if (player.getDom(i).getValue2()==board.pattern[j]){
            
            if((j-11)>=0 && player.getDom(i).getValue() ==board.pattern[j-11])
               return false;
            else if((j-1)>=0 && player.getDom(i).getValue() ==board.pattern[j-1])
                return false;
            else if((j+11)<121 && player.getDom(i).getValue() ==board.pattern[j+11])
                return false;
            else if(j+1<121 && player.getDom(i).getValue() ==board.pattern[j+1])
                return false;
        }
    }
}
return true;
}

void winner(String name){
    System.out.println("Player "+ name +" Won!!!!");
}

}