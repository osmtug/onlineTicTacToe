package serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import grille.GrilleTicTacToe;

public class Serveur {
	
	public static GrilleTicTacToe grille;
	public static boolean[] est_fini = {false,false} ;
	public static int currentP = 0;
	
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			grille = new GrilleTicTacToe();
			ServerSocket server = new ServerSocket(5555);
			
			System.out.println("Server lancé");
			
			Socket[] s = new Socket[2];
			
			s[0] = server.accept();
			System.out.println("Client 1 connecté");
			
			s[1] = server.accept();
			System.out.println("Client 2 connecté");
			
			ObjectInputStream[] in = new ObjectInputStream[2];
			ObjectOutputStream[] out = new ObjectOutputStream[2];
			
			out[0] = new ObjectOutputStream(s[0].getOutputStream());
			out[1] = new ObjectOutputStream(s[1].getOutputStream());
			
			in[0] = new ObjectInputStream(s[0].getInputStream());
			in[1] = new ObjectInputStream(s[1].getInputStream());
			String sendedMessage = "play";
			do {
				out[currentP].writeObject(sendedMessage);
				out[currentP].flush();
				out[currentP].writeObject(grille.toString());
				out[currentP].flush();
				
				int[] position = (int[]) in[currentP].readObject();
				
				if(grille.checkValidePosition(position[0], position[1])) {
					grille.placeSymbole(currentP+1, position[0], position[1]);
					sendedMessage = "play";
					changePlayer();
					System.out.println(grille);
				}else {
					sendedMessage = "invalide-position";
				}
			}while(!check_aligned_symbols(grille) && !grille.tie());
			
			if(check_aligned_symbols(grille)) {
				out[currentP].writeObject("lose");
				changePlayer();
				out[currentP].writeObject("win");
			}else {
				out[currentP].writeObject("tie");
				changePlayer();
				out[currentP].writeObject("tie");
			}
			
			server.close();
			System.out.println("Server arrêté");
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Probème sur le Server");
		}
	}
	
	public static void changePlayer() {
		currentP = (currentP + 1) % 2;
	}
	
	public static boolean check_aligned_symbols(GrilleTicTacToe grille) {
		return grille.checkAlignedSymbols();
	}
}
