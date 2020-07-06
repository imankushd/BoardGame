package com.ankush;

public class Player implements Runnable {
	
	int player;
	
	Board board;
	
	int rem;
	
	int number_upto = 1000;
	
	static int i=0;
	
	static Object lock = new Object();
	
	Player(Board board,int rem)
	{
		this.rem = rem;
		this.board = board;
	}

	public void run() {
		
		while(i < number_upto)
		{	
			synchronized (lock) {
				while(i%4!=rem)
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				player = i%4 +1;
								
				int turn = board.dice.throwDice();
				board.score[i%4] +=  turn;
				System.out.println("Player "+player+" chance with total score: "+board.score[i%4]);
				
				/*
				 * if(Board.sum[i%4] > 100) Board.sum[i%4] -= turn;
				 */
				
				if(board.score[i%4] >= 100)
				{
					int winner =i%4;
					System.out.println("Player "+(winner+1)+" is the winner. ");
					System.exit(0);
				}
					
				i++;
				lock.notifyAll();
			}
			
		}
		
	}

}
