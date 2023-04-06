package control;

import frontiere.Client;
import frontiere.Reservation;
import frontiere.ReservationRestaurant;
import model.CarnetClientele;
import model.Formulaire;
import model.FormulaireRestaurant;
import model.Restaurant;

public class ControlReserverTable {
	private CarnetClientele carnetClientel;
	private Formulaire[] formulaires = new Formulaire[50];
	private Restaurant restaurant = new Restaurant();
	
	public int[] trouverPossibilite(int jour, int mois, int nombrePersonnes, int numService) {
		FormulaireRestaurant formulaire = new FormulaireRestaurant(jour, mois, numService, nombrePersonnes);
		boolean formulaireEnregistrer = false;
		int numeroFormulaire = -1;
		for (int i = 0; i < formulaires.length && !formulaireEnregistrer; i++) {
			if (formulaires[i] == null) {
				formulaires[i] = formulaire;
				formulaireEnregistrer = true;
				numeroFormulaire = i;
			}
		}
		int[] possibilites = restaurant.donnerPossibilite(formulaire);
		int[] retour = new int[possibilites.length + 1];
		retour[0] = numeroFormulaire;
		for (int i = 1; i < possibilites.length + 1; i++) {
			retour[i] = possibilites[i - 1];
		}
		return retour;
	}
	
	public void reserver(int numClient, int numProposition, int numeroFormulaire) {
		FormulaireRestaurant formulaireRestaurant = formulaires[numeroFormulaire];
		formulaires[numeroFormulaire] = null;
		Reservation reservation = restaurant.reserver(numProposition, formulaireRestaurant);
		if (reservation instanceof ReservationRestaurant) {
			ReservationRestaurant reservationRestaurant = (ReservationRestaurant) reservation;
			Client client = carnetClientel.getClient(numClient);
			client.ajouterReservation(reservation);
		}
	}
}
