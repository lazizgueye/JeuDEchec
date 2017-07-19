package TP5_Leopold_Aziz_GUEYE_et_Fama_Ndiaye;

import javax.swing.JLabel;

public class Fou extends Piece{
	
	private Echiquier Echiquier;
	private Case LaCase;
	private boolean Deplacement;

	public Fou(Echiquier echiquier, Case laCase, boolean deplacement){
		this.Echiquier = echiquier;
		this.LaCase = laCase;
		this.Deplacement = deplacement;
	}
	
	@Override
	public String toString() {
		return "F";
	}
	
	@Override
	public void moveTo(Case caseInit, Case caseDestination) {
		boolean Libre = true;
		boolean Testeur = false;
		
		if(this.Echiquier.getTour() == this.Deplacement){
			//deplacement possible que si la case de destination est vide
			// ou, si la case est occupé, on s'assure que c'est le jeton adverse			
			if((caseDestination.P == null)||((caseDestination.P != null)&&(caseDestination.P.isBlue != caseInit.P.isBlue))){
				if((Math.abs((caseInit.x-caseInit.y)%2)== Math.abs((caseDestination.x-caseDestination.y)%2))
						&&(Math.abs(caseInit.x - caseDestination.x) == Math.abs(caseInit.y - caseDestination.y))){		
					
					// diagonal haut vers gauche
					if((caseInit.x<caseDestination.x)&&(caseInit.y>caseDestination.y)){
						int j = caseInit.y;
						for(int i=caseInit.x+1; i<caseDestination.x; i++){
							j--;
							if(Echiquier.cases[i][j].P != null){
								Libre = false;
								i = caseDestination.x;
							}
						}
						Testeur = true;
					}
					// diagonal haut vers droite
					else if((caseInit.x<caseDestination.x)&&(caseInit.y<caseDestination.y)){
						int j = caseInit.y;
						for(int i=caseInit.x+1; i<caseDestination.x; i++){
							j++;
							if(Echiquier.cases[i][j].P != null){
								Libre = false;
								i = caseDestination.x;
							}
						}
						Testeur = true;
					}
					// diagonal bas vers gauche
					else if((caseInit.x>caseDestination.x)&&(caseInit.y>caseDestination.y)){
						int j = caseInit.y;
						for(int i=caseInit.x-1; i>caseDestination.x; i--){
							j--;
							if(Echiquier.cases[i][j].P != null){
								Libre = false;
								i = caseDestination.x;
							}
						}
						Testeur = true;
					}
					// diagonal bas vers droite
					else if((caseInit.x>caseDestination.x)&&(caseInit.y<caseDestination.y)){
						int j = caseInit.y;
						for(int i=caseInit.x-1; i>caseDestination.x; i--){
							j++;
							if(Echiquier.cases[i][j].P != null){
								Libre = false;
								i = caseDestination.x;
							}
						}
						Testeur = true;
					}
					if(Libre && Testeur){
						caseDestination.P = new Fou(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
						caseDestination.P.isBlue = isBlue;		
						caseInit.P = null;
						echecEtMat(Echiquier);
						this.Echiquier.changeTour();		// donne la main
					}
				}
			}
		}
	}
}
