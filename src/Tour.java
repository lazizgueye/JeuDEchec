package TP5_Leopold_Aziz_GUEYE_et_Fama_Ndiaye;

import javax.swing.JLabel;

public class Tour extends Piece{
	
	private Echiquier Echiquier;
	private Case LaCase;
	private boolean Deplacement;

	public Tour(Echiquier echiquier, Case laCase, boolean deplacement){
		this.Echiquier = echiquier;
		cases[laCase.x][laCase.y] = laCase;
		this.Deplacement = deplacement;
	}
	
	@Override
	public String toString() {
		return "T";
	}
	
	@Override
	public void moveTo(Case caseInit, Case caseDestination) {
		boolean Libre = true;
		
		if(this.Echiquier.getTour() == this.Deplacement){
			//deplacement possible que si la case de destination est vide
			// ou, si la case est occupé, on s'assure que c'est le jeton adverse
			if((caseDestination.P == null)||((caseDestination.P != null)&&(caseDestination.P.isBlue != caseInit.P.isBlue))){
				
				// verifie deplacement si colonne
				if(caseDestination.x == caseInit.x){				
					//si deplacement vers la droite est superieur o moins a 2 cases
					if((caseDestination.y > caseInit.y)&&(Math.abs(caseDestination.y - caseInit.y)>=2)){
						for(int i=caseInit.y+1; i<caseDestination.y; i++){
							if(Echiquier.cases[caseInit.x][i].P != null){
								Libre = false;
								i = caseDestination.y;
							}							
						}
					}
					else if((caseDestination.y < caseInit.y)&&(Math.abs(caseDestination.y - caseInit.y)>=2)){
						for(int i=caseInit.y-1; i>caseDestination.y; i--){
							if(Echiquier.cases[caseInit.x][i].P != null){
								Libre = false;
								i = caseDestination.y;
							}							
						}
					}
					// test la vaaleur de libre
					if(Libre){
						caseDestination.P = new Tour(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
						caseDestination.P.isBlue = isBlue;		
						caseInit.P = null;
						echecEtMat(Echiquier);
						this.Echiquier.changeTour();		// donne la main
					}
				}
				
				// verifie deplacement si rangé
				else if(caseDestination.y == caseInit.y){					
					//si deplacement vers la droite est superieur o moins a 2 cases
					if((caseDestination.x > caseInit.x)&&(Math.abs(caseDestination.x - caseInit.x)>=2)){
						for(int i=caseInit.x+1; i<caseDestination.x; i++){
							if(Echiquier.cases[i][caseInit.y].P != null){
								Libre = false;
								i = caseDestination.x;
							}							
						}
					}
					else if((caseDestination.x < caseInit.x)&&(Math.abs(caseDestination.x - caseInit.x)>=2)){
						for(int i=caseInit.x-1; i>caseDestination.x; i--){
							if(Echiquier.cases[i][caseInit.y].P != null){
								Libre = false;
								i = caseDestination.x;
							}							
						}
					}
					// test la vaaleur de libre
					if(Libre){
						caseDestination.P = new Tour(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
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
