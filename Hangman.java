/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */
//test
import acm.graphics.*;
import acm.program.*;
import acm.util.*;


import java.awt.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Hangman extends ConsoleProgram {
	public File lexicon = new File("HangmanLexicon.txt");
	public static String answer;
	public static String guesser;
	public static char guess;
	public static int answerlen;
	public static char[] answerarr;
	public static char[] guessarr;
	public static char[] dasharr;
	public static int nturns = 8;
	public static int pturns = 0;
	public static int winner;
	public static boolean wincheck = false;
	public static boolean losecheck = false;
	public static Scanner read = new Scanner(System.in);
	public static int n;
	private HangmanCanvas canvas;
    public void run(){
    	int x = 0;
    	Random rand = new Random();
	    
	     try {
			for(Scanner sc = new Scanner(lexicon); sc.hasNext(); )
			 {
			    ++n;
			    String line = sc.nextLine();
			    if(rand.nextInt(n) == 0)
			      answer = line;         
			 }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//println(answer);
    	answerlen = answer.length();
    	//println(answerlen);
    	winner = 0;
    	answerarr = new char[answerlen];
    	guessarr = new char[answerlen];
    	dasharr = new char[answerlen]; 
    	for(int i = 0; i<answerlen; i++){
    		char ans = answer.charAt(i);
    		answerarr[i] = ans;
    		dasharr[i] = '-';
    	}
    	print("your current board is ");
    	for(int i = 0; i<answerlen; i++){
    		print(dasharr[i]+" ");
    	}
    	println("\n");
    	while(wincheck==false && losecheck == false){
    	println("you have " + nturns + " guesses");
    	println("Enter a Character \n");
    	guesser = readLine();
    	guess = guesser.charAt(0);
    	
    	println("Your guess is : " + guess);
    	x=0;
    	for(int i = 0; i<answerlen; i++ ){
    		if(guess == answerarr[i]){
    			guessarr[i] = guess;
    			x++;
    			println("your current board is: " );
    			for(int board = 0; board <answerlen; board++){
    				
    				if(board == i ){
    					dasharr[board] = guess;
    					print(dasharr[board]+ " ");
    				}else{
    					print(dasharr[board]+" ");
    				}
    				
    			}
    			
    			//winner++;
    		}
    	}
    	if(x>0 && x<2){
    		println("Your guess " + guess + " is correct.");
    		//nturns--;
    		winner++;
    		//println("winner = " + winner);
    	}else if (x == 2){
    		winner = winner+2;
    		//println("winner = " + winner);
    	}
    	else{
    		println("Your guess " + guess + " is incorrect.");
    		nturns--;
    		switch(nturns){
    		case 7: canvas.head();
    				add(canvas);
    				break;
    		case 6: canvas.body();
    				add(canvas);
    				break;
    		case 5: canvas.arm1();
    				add(canvas);
    				break;
    		case 4: canvas.arm2();
    				add(canvas);
    				break;
    		case 3: canvas.leg1();
    				add(canvas);
    				break;
    		case 2: canvas.leg2();
    				add(canvas);
    				break;
    		case 1: canvas.foot1();
    				add(canvas);
    				break;
    		default: 
    		}
    	}
    	if(winner == answerlen){
    		wincheck = true;
    		//losecheck = true;
    		//println(wincheck);
    	}else{
    		wincheck = false;
    	}
    	if(nturns == 0){
    		losecheck = true;
    	}else{
    		losecheck = false;
    	}
	}
    	if(winner == answerlen){
    		println("you guessed the word: "+ answer +" correctly");
    	}else if (nturns == 0){
    		canvas.foot2();
    		add(canvas);
    		println("you ran out of guesses :(");
    		println("the answer was: " + answer );
   		}
    }
    
    public void init(){
    	canvas = new HangmanCanvas();  	
    	
    			canvas.reset();
    			add(canvas);
    	
    }
}
