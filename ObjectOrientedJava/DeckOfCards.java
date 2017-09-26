package com.bridgeit.javaObjectOrientedPrograms.Programs;

import com.bridgeit.javaObjectOrientedPrograms.Utility.Utility;

public class DeckOfCards {
	public static void main(String[] args) 
	{   
		
		int[] deck = new int[52];
		String[] arr= new String[52];
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		int []deck1=Utility.initialize(deck);
		int []al=Utility.shuffleCards(deck1);
		String[] arr1=Utility.generateCard(arr,al,suits,ranks);
		Utility.distribute(deck,arr1);
	}
}
