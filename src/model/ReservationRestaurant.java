package model;

public class ReservationRestaurant extends Reservation{
	int service;
	int numTable;
	
	public ReservationRestaurant (int jour, int mois, int service, int numTable) {
		super(jour, mois);
		this.service = service;
		this.numTable = numTable;
	}
	
	public String toString() {
		String chaine = "Le " + jour + "/" + mois + " : table n�" + numTable;
		if(service==1) {
			chaine += " pour le premier service.";
		}
		else {
			chaine += " pour le deuxième service.";
		}
		return chaine;
	}
}
