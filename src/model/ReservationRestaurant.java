package model;

public class ReservationRestaurant extends Reservation{
	private int service;
	private int numTable;
	
	public ReservationRestaurant (int jour, int mois, int service, int numTable) {
		super(jour, mois);
		this.service = service;
		this.numTable = numTable;
	}
	
	@Override
	public String toString() {
		String chaine = "Le " + getJour() + "/" + getMois() + " : table n°" + numTable;
		if(service==1) {
			chaine += " pour le premier service.\n";
		}
		else {
			chaine += " pour le deuxième service.\n";
		}
		return chaine;
	}
}
