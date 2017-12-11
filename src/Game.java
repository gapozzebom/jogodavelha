import java.util.Scanner;
import java.util.function.ToIntBiFunction;


public class Game {

	private String [][] board = new String [3][3];
	private Computer cp = new Computer();
	
	public Game (){
		System.out.println("Bem vindo ao jogo da Velha");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = "_";
			}
		}
		iniciarJogada(board);
	}
	
	private void iniciarJogada(String [][] board) {
		// TODO Auto-generated method stub
		System.out.println("Escolha uma posição");
		System.out.println("  0 - 1 - 2");
		System.out.println("0 " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] );
		System.out.println("1 " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] );
		System.out.println("2 " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] );
		System.out.println("Qual sua jogada?");
		Scanner s = new Scanner(System.in);
		int lin = Integer.parseInt(s.nextLine());
		int col = Integer.parseInt(s.nextLine());
		board[lin][col] = "x";
		
		/*
		board [0][0]= "x";
		board [0][1]= "o";
		board [0][2]= "x";
		board [1][0]= "o";
		board [1][1]= "o";
		board [1][2]= "x"; 
		*/
		Move cpMove = cp.findBestMove(board);
		board[cpMove.lin][cpMove.col] = "o";
		System.out.println("ROW: " + cpMove.lin +  " COL: " + cpMove.col );
		if (cp.evaluate(board) != 0) {
			System.out.println("O jogo Acabou");
		}
		else {
			iniciarJogada(board);
		}
		
		 

	}

	public boolean hasPlayerWon()
	{
		//linha
		for (int i=0; i < 3; i++)
	    {
	        if (board[i][0] == board[i][1] &&
	            board[i][1] == board[i][2] && 
	            board[i][0] != " ")
	            return (true);
	    }
		//coluna
		for (int i = 0; i < 3; i++)
	    {
	        if (board[0][i] == board[1][i] &&
	            board[1][i] == board[2][i] && 
	            board[0][i] != " ")
	            return (true);
	    }
		if (board[0][0] == board[1][1] &&
		        board[1][1] == board[2][2] && 
		        board[0][0] != " ")
		        return(true);
		         
		    if (board[0][2] == board[1][1] &&
		        board[1][1] == board[2][0] &&
		         board[0][2] != " ")
		        return(true);
		
		return false;
	}
	


}
