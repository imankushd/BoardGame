package com.ankush;

public class TheGame {
	
	public static void main(String args[])
	{
		Board b = new Board();
		
		Player p = new Player(b,0);
		Player p1 = new Player(b,1);
		Player p2 = new Player(b,2);
		Player p3 = new Player(b,3);
		
		new Thread(p).start();
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
	}
	
}
