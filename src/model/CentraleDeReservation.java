package model;

public class CentraleDeReservation <F extends Formulaire>{
	EntiteReservable<F>[] entites;
	int nbEntite;
	
	public CentraleDeReservation(EntiteReservable<F>[] entite) {
		nbEntite = 0;
		this.entites = entite;
	}
	
	public void ajotuerEntite(EntiteReservable<F> entite){
		entites[nbEntite] = entite;
		nbEntite++;
		entite.setNumid(nbEntite);
	}
	
	public int[] donnerPossibilites(F formulaire) {
		int[] possibilites = new int[nbEntite];
		for(int i = 0; i<nbEntite; i++) {
			if(entites[i].compatible(formulaire)) {
				possibilites[i] = entites[i].getNumid();
				System.out.println(entites[i].getNumid());
			}else {
				possibilites[i] = 0;
			}
		}
		return possibilites;
	}
	
	public Reservation reserver(int numEntite, F formulaire) {
		int numE = entites[0].getNumid();
		int i = 1;
		while(i<nbEntite && numE != numEntite) {
			numE = entites[i].getNumid();
			i++;
		}
		formulaire.setEntiteReserve(numEntite);
		Reservation reserve = entites[i].reserver(formulaire);
		return reserve;
	}
	
}
