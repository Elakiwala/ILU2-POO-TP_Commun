package model;

public class FormulaireRestaurant extends Formulaire{
	int service;
	int personnes;
	
	public FormulaireRestaurant(int jour, int mois, int personne, int service) {
		super(jour, mois);
		this.service = service;
		this.personnes = personne;
	}

	public int getService() {
		return service;
	}

	public int getPersonnes() {
		return personnes;
	}
	
}
