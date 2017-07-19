package TP5_Leopold_Aziz_GUEYE_et_Fama_Ndiaye;

import javax.swing.JLabel;

public class Reine extends Piece{
	
	private Echiquier Echiquier;
	private Case LaCase;
	private boolean Deplacement;

	public Reine(Echiquier echiquier, Case laCase, boolean deplacement){
		this.Echiquier = echiquier;
		this.LaCase = laCase;
		this.Deplacement = deplacement;
	}
	
	@Override
	public String toString() {
		return "D";
	}
	
	@Override
	public void moveTo(Case caseInit, Case caseDestination) {
		boolean Libre = true;
		boolean Testeur = false;
	
		if(this.Echiquier.getTour() == this.Deplacement){
			//deplacement possible que si la case de destination est vide
			// ou, si la case est occupé, on s'assure que c'est le jeton adverse			
			if((caseDestination.P == null)||((caseDestination.P != null)&&(caseDestination.P.isBlue != caseInit.P.isBlue))){
				
				///******* deplacement diagonal comme le Fou ***********///
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
						caseDestination.P = new Reine(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
						caseDestination.P.isBlue = isBlue;		
						caseInit.P = null;
						echecEtMat(Echiquier);
						this.Echiquier.changeTour();		// donne la main
					}
				}
				
				///******* deplacement plusieur case comme la Tour ********///
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
						caseDestination.P = new Reine(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
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
						caseDestination.P = new Reine(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
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
