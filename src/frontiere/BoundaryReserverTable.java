package frontiere;

import java.util.Scanner;
//import control.Client;
import control.ControlReserverTable;
//import control.Reservation;
//import control.ReservationRestaurant;
import model.FormulaireRestaurant;

public class BoundaryReserverTable {
	private Scanner scanner = new Scanner(System.in);
	private ControlReserverTable controleReserverTable = new ControlReserverTable();
	
	public void reserverTable(int numClient) {
		System.out.println("Quand souhaites vous reservez?\n");
		System.out.println("Pour quel mois?\n");
		int mois = scanner.nextInt();
		System.out.println("Pour quel jour?\n");
		int jour = scanner.nextInt();
		System.out.println("Pour combien de personnes?\n");
		int nombrePersonnes = scanner.nextInt();
		System.out.println("Pour quel service?\n");
		int numService = scanner.nextInt();
		int[] possibilites = controleReserverTable.trouverPossibilite(jour, mois, nombrePersonnes, numService);
		for (int i = 1; i<possibilites.length; i++) {
			System.out.println("numéro table: " + possibilites[i]);
		}
		System.out.println("Choisissez votre table\n");
		int numTable = scanner.nextInt();
		controleReserverTable.reserver(numClient, numTable, possibilites[0]);
	}
}
