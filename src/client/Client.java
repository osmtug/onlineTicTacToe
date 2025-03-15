package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import grille.GrilleTicTacToe;


public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 5555);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			
			Scanner sc = new Scanner(System.in);
			
			String msg = "";
			
			do {
				msg = (String) in.readObject();			
			} while (msg.compareTo("play")!=0 );
			
			
			do {
				System.out.println(msg);
				
				String grille = (String) in.readObject();	
				System.out.println(grille);
				int[] position = new int[2];
				
				System.out.println("entrez la ligne du prochain coup");
				position[0] = sc.nextInt()-1;
				System.out.println("entrez la colonne du prochain coup");
				position[1] = sc.nextInt()-1;
				
				out.writeObject(position);
				out.flush();
				
				msg = (String) in.readObject();			
			} while (msg.compareTo("win")!=0 && msg.compareTo("lose")!=0 && msg.compareTo("tie")!=0 );
			
			System.out.println(msg);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
