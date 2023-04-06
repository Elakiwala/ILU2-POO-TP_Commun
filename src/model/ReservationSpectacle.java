package model;

public class ReservationSpectacle extends Reservation {
	int zone;
	int numChaise;
	
	public ReservationSpectacle(int jour, int mois, int zone, int numChaise) {
		super(jour, mois);
		this.zone = zone;
		this.numChaise = numChaise;
	}

	public String toString() {
		String chaine = "Le "+ jour + "/" + mois + " :  chaise n°" + numChaise + " à la zone n°" + numZone + ".";
		return chaine;
	}
}
