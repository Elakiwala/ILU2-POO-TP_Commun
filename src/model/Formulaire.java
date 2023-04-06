package model;

public abstract class Formulaire{
	int jour;
	int mois;
	int entiteReserve;
	
	public Formulaire(int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
	}

	public int getEntiteReserve() {
		return entiteReserve;
	}

	public void setEntiteReserve(int entiteReserve) {
		this.entiteReserve = entiteReserve;
	}

	public int getJour() {
		return jour;
	}

	public int getMois() {
		return mois;
	}
	
	
}
