package day1;

import java.util.Scanner;

public class ChipsGame {
	
	private int initialchips;	
	public Player player1;
	public Player player2;
	private int turn;
	
	
	public ChipsGame(){
		this.player1=new Player();
		this.player2=new Player();
		turn=1;
	}
	public void InitGame(){
		this.player1.setName("");this.player1.nbreChips=0;
		this.player2.setName("");this.player2.nbreChips=0;
		initialchips=0;
		turn=1;
	}
	
	public void Start(){
		do{
			
		System.out.println("Enter name o player1");
		Scanner scan=new Scanner(System.in);
		player1.setName(scan.nextLine().toString());
		System.out.println("name:"+player1.getName());
		}while(player1.getName().trim().length()<1);
		do{
			System.out.println("Enter name o player2");
			Scanner scan2=new Scanner(System.in);
			player2.setName(scan2.nextLine().toString());
		}while(player2.getName().equals(player1.getName())||player2.getName().trim().length()<1);
		
		boolean good=false;
		do{
			if(good&&initialchips<3){
				System.out.println("INFO:You have to start with at least 3 chips!");}
			if(good&&initialchips%2==0){
				System.out.println("INFO:You have to start with an odd number of chips!");}
			System.out.println();
			System.out.println("How many chips does the initial pile contain?");
			Scanner scan3=new Scanner(System.in);
			try{          
				
				initialchips = Integer.parseInt(scan3.nextLine().trim());
				good=true;
			}catch(Exception e){				
				System.out.println("INFO:Should be an integer!");				
				good=false;
			}
			
		}while(initialchips<3 ||initialchips%2==0);
		
		do{
			printstate();
			getChips(turn);
			
		}while(initialchips>0);
		
		
	}
	
	private void printstate(){
		System.out.println(player1.getName()+" has "+player1.getNbreChips()+" chips");
		System.out.println(player2.getName()+" has "+player2.getNbreChips()+" chips");
	}
	
	public void printwinner(){
	  if(player1.getNbreChips()%2==0)
		  System.out.println(player1.getName()+" wins");
	  else
		  System.out.println(player2.getName()+" wins");
	}
	private boolean getChips(int turn){
		boolean good=false;
		int input=0;
		int val;
		boolean even=initialchips%2==0;
		if(initialchips>1&&even){
			 val=(initialchips / 2 );
		}
		else{  
			if(initialchips==1)
				val=1;
			else{
			val=((initialchips -1)/ 2 );}
		}
		
		if(turn==1){
			System.out.println("It is your turn,"+player1.getName());
			System.out.println("There are "+initialchips+" chips remaining");
			
			if(!even){
				System.out.println("You may take any number of chips from 1 to "+val+" How many will you take,"+player1.getName()+"?");
			}else{
				System.out.println("You may take any number of chips from 1 to "+val+" How many will you take,"+player1.getName()+"?");
			}
					
			do{
				if(good&&input<1){System.out.println("Illegal move: you must take at least one chip");
				System.out.println("How many will you take,"+player1.getName()+"?");}
				if(good&&input>val){
				System.out.println("Illegal move: you may not take more than"+ val+" chips");
				System.out.println("");  	
				}
				Scanner scan3=new Scanner(System.in);
				try{          
					
					input = Integer.parseInt(scan3.nextLine().trim());
					good=true;
				}catch(Exception e){				
					System.out.println("INFO:Should be an integer!");				
					good=false;
				}
				
			}while(input<1||(input%2!=0&&input>val)||(input%2==0&&input>val));
			player1.setNbreChips(player1.getNbreChips()+input);
			this.turn=2;
			initialchips=initialchips-input;
			return true;
		}else{
			System.out.println("It is your turn,"+player2.getName());
			System.out.println("There are "+initialchips+" chips remaining");
			
			if(!even){
				System.out.println("You may take any number of chips from 1 to "+val+" How many will you take,"+player2.getName()+"?");
			}else{
				System.out.println("You may take any number of chips from 1 to "+val+" How many will you take,"+player2.getName()+"?");
			}
					
			do{
				if(good&&input<1){System.out.println("Illegal move: you must take at least one chip");
				System.out.println("How many will you take,"+player2.getName()+"?");}
				if(good&&input>val){
				System.out.println("Illegal move: you may not take more than"+ val+" chips");
				System.out.println("");  	
				}
				Scanner scan3=new Scanner(System.in);
				try{          
					
					input = Integer.parseInt(scan3.nextLine().trim());
					good=true;
				}catch(Exception e){				
					System.out.println("INFO:Should be an integer!");				
					good=false;
				}
				
			}while(input<1||(input%2!=0&&input>val)||(input%2==0&&input>val));
			player2.setNbreChips(player2.getNbreChips()+input);
			initialchips=initialchips-input;
			this.turn=1;
			return true;
		}
		
	}
	
	class Player{
		
		private String name;
		private int nbreChips;
		
		
		public Player() {
			super();
			this.name =null;
			this.nbreChips = 0;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the nbreChips
		 */
		public int getNbreChips() {
			return nbreChips;
		}
		/**
		 * @param nbreChips the nbreChips to set
		 */
		public void setNbreChips(int nbreChips) {
			this.nbreChips = nbreChips;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean exit=false;
		ChipsGame c=new ChipsGame();
		
		do{
		c.Start();
		c.printstate();
		c.printwinner();
		
		System.out.println("Play another game? (y/n) y ");
		Scanner scan2=new Scanner(System.in);
		switch(scan2.nextLine().toString().trim().charAt(0)){
			
		case 'y':
			exit=false;c.InitGame();break;
		default :
			exit=true;break;		
		}
		for(int i=0;i<20;i++)
			System.out.println();
		}while(exit==false);

	}

}
