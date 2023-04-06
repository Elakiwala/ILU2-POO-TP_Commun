package model;

public class FormulaireHotel extends Formulaire{
	int nbLitSimple;
	int nbLitDouble;
	
	public FormulaireHotel(int jour, int mois, int nbLitSimple, int nbLitDouble) {
		super(jour, mois);
		this.nbLitDouble = nbLitSimple;
		this.nbLitSimple = nbLitSimple;
	}

	public int getNbLitSimple() {
		return nbLitSimple;
	}

	public int getNbLitDouble() {
		return nbLitDouble;
	}
	
}
