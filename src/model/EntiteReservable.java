package model;

public abstract class EntiteReservable<F extends Formulaire> {
	CalendrierAnnuel calendrierPerso = new CalendrierAnnuel();
	int numid;
	
	public int getNumid() {
		return numid;
	}
	public void setNumid(int numid) {
		this.numid = numid;
	}
	
	public boolean estLibre(F dateFormulaire) {
		int jour = dateFormulaire.getJour();
		int mois = dateFormulaire.getJour();
		return calendrierPerso.estLibre(jour, mois);
	}
	
	public abstract boolean compatible(F formulaire);
	public abstract Reservation reserver(F resFormulaire);
}
