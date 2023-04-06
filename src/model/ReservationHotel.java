package model;

public class ReservationHotel extends Reservation{
	int nbLitSimple;
	int nbLitDouble;
	int numChambre;
	
	public ReservationHotel (int jour, int mois, int nbLitSimple, int nbLitDouble, int numChamber, int numChambre) {
		super(jour, mois);
		this.nbLitSimple = nbLitSimple;
		this.nbLitDouble = nbLitDouble;
		this.numChambre = numChambre;
	}
	
	public String toString() {
		String chaine = "Le "+jour+"/"+mois + " : " + nbLitSimple + " lits simples et " + nbLitDouble + " lits doubles pour la chambre n°"+numChambre + ".";
		return chaine;
	}
}
