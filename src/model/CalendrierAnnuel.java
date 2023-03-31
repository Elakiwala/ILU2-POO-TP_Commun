package model;

public class CalendrierAnnuel {
	private Mois[] calendrier = new Mois[12];
	
	public CalendrierAnnuel() {
		calendrier[0] = new Mois("Janvier", 31); 
		calendrier[1] = new Mois("Fevrier", 28); 
		calendrier[2] = new Mois("Mars", 31); 
		calendrier[3] = new Mois("Avril", 30); 
		calendrier[4] = new Mois("Mai", 31); 
		calendrier[5] = new Mois("Juin", 30); 
		calendrier[6] = new Mois("Juillet", 31); 
		calendrier[7] = new Mois("Août", 31); 
		calendrier[8] = new Mois("Septembre", 30); 
		calendrier[9] = new Mois("Octobre", 31); 
		calendrier[10] = new Mois("Novembre", 30); 
		calendrier[11] = new Mois("Décembre", 31); 
	}
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour);
	}
	
	public boolean reserver(int jour, int mois) {
		if(estLibre(jour, mois)) {
			calendrier[mois-1].reserver(jour);
			return true;
		}else {
			return false;
		}
	}
	
							////// CLASSE INTERNE MOIS //////
	private static class Mois{
		private String nom;
		private boolean[] jour;
		
		public Mois(String nom, int nbJoursMois) {
			this.nom = nom;
			jour = new boolean[nbJoursMois];
			for(int i=0; i<jour.length; i++) {
				jour[i] = false;
			}
		}
		
		public boolean estLibre(int journee) {
			return !jour[journee-1]; 
		}
		
		public void reserver(int journee) {
			if(estLibre(journee)) {
				jour[journee-1] = true;
			}else{
				throw new IllegalStateException("Pas libre\n");
			}
		}
	}
}
