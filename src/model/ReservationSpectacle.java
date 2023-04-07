package model;

public class ReservationSpectacle extends Reservation {
	private int zone;
	private int numChaise;
	
	public ReservationSpectacle(int jour, int mois, int zone, int numChaise) {
		super(jour, mois);
		this.zone = zone;
		this.numChaise = numChaise;
	}

	@Override
	public String toString() {
		String chaine = "Le "+ getJour()+ "/" + getMois()+ " :  chaise n°" + numChaise + " à la zone n°" + zone + ".";
		return chaine;
	}
}
