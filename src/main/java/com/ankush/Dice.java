package com.ankush;

import java.util.Random;

public class Dice {

	public int throwDice()
	{
		Random r = new Random();
		int c= r.nextInt(7);
		while(c==0)
		{
			c = r.nextInt(7);
		}
		
		return c;
	}
}
