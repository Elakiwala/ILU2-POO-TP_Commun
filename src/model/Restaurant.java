package model;

public class Restaurant {
	private CentraleDeReservation<FormulaireRestaurant> centrale = new CentraleDeReservation<FormulaireRestaurant>(new EntiteReservable[50]);
	private CalendrierAnnuel calendrierAnnuel;
	
	private class Table extends EntiteReservable<FormulaireRestaurant>{
		private int nbChaises;
		private CalendrierAnnuel calendrierDeuxiemeService;
		
		public Table(int nbChaises) {
			this.nbChaises = nbChaises;
			calendrierDeuxiemeService = new CalendrierAnnuel();
		}
		
		public ReservationRestaurant reserver(FormulaireRestaurant formulaireRestaurant) {
			int jour = formulaireRestaurant.getJour();
			int mois = formulaireRestaurant.getMois();
			int service = formulaireRestaurant.getService();
			int id = formulaireRestaurant.getEntiteReserve();
			if(compatible(formulaireRestaurant)) {
				if(formulaireRestaurant.getService() == 1) {
					calendrierAnnuel.reserver(jour, mois);
				}else {
					calendrierDeuxiemeService.reserver(jour, mois);
				}
				ReservationRestaurant reserve = new ReservationRestaurant(jour, mois, service, id);
				return reserve;
			}else return null;
		}
		
		public boolean TableLibre(FormulaireRestaurant formulaireRestaurant) {
			if(formulaireRestaurant.getService() == 1) {
				int jour = formulaireRestaurant.getJour();
				int mois = formulaireRestaurant.getMois();
				return calendrierAnnuel.estLibre(jour, mois);
			}else {
				int jour = formulaireRestaurant.getJour();
				int mois = formulaireRestaurant.getMois();
				return calendrierDeuxiemeService.estLibre(jour, mois);
			}
		}
		
		public boolean compatible(FormulaireRestaurant formulaireRestaurant) {
			int convive = formulaireRestaurant.getPersonnes();
			boolean chaiseParPers = ((nbChaises == convive) || (nbChaises+1 == convive));
			boolean tableLibre = TableLibre(formulaireRestaurant);
			return chaiseParPers && tableLibre;
		}
	}
	
	public void ajouterTable(int nbChaise) {
		Table table = new Table(nbChaise);
		centrale.ajouterEntite(table);
	}
	
	public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
		return centrale.donnerPossibilites(formulaire);
	}
	
	public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
		return centrale.reserver(numEntite, formulaire);
	}
}
