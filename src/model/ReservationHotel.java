package model;

public class ReservationHotel extends Reservation {
	private int nbLitSimple;
	private int nbLitDouble;
	private int numChambre;

	public ReservationHotel(int jour, int mois, int nbLitSimple, int nbLitDouble, int numChamber, int numChambre) {
		super(jour, mois);
		this.nbLitSimple = nbLitSimple;
		this.nbLitDouble = nbLitDouble;
		this.numChambre = numChambre;
	}
	
	@Override
	public String toString() {
		String chaine = "Le " + getJour() + "/" + getMois() + " : " + nbLitSimple + " lits simples et " + nbLitDouble
				+ " lits doubles pour la chambre n°" + numChambre + ".";
		return chaine;
	}
}
