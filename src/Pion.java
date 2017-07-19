package TP5_Leopold_Aziz_GUEYE_et_Fama_Ndiaye;

import java.awt.Color;

import javax.swing.JLabel;


public class Pion extends Piece{
	
	private Case LaCase;
	private boolean Deplacement;
	protected Echiquier Echiquier;

	public Pion(Echiquier echiquier, Case laCase, boolean deplacement){		
		this.LaCase = laCase;
		this.Deplacement = deplacement;
		this.Echiquier = echiquier;
	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public void moveTo(Case caseInit, Case caseDestination) {
		boolean Libre = true;
		
		if(this.Echiquier.getTour() == this.Deplacement){
			// deplacement possible que si la case de destination est vide
			// ou, si la case est occupé, on s'assure que c'est le jeton adverse
			if((caseDestination.P == null)||((caseDestination.P != null)&&(caseDestination.P.isBlue != caseInit.P.isBlue))){	
				
				// deplacement 1 case devant pion Bleu sans recule
				if((Math.abs(caseDestination.x - caseInit.x)==1)&&(Math.abs(caseDestination.y - caseInit.y)==0)
						&&(caseInit.x<caseDestination.x)&&(Echiquier.cases[caseInit.x][caseInit.y].P.isBlue == true)
						&&(Echiquier.cases[caseDestination.x][caseDestination.y].P == null)){
					caseDestination.P = new Pion(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
					caseDestination.P.isBlue = isBlue;
					caseInit.P = null;
					echecEtMat(Echiquier);
					this.Echiquier.changeTour();		// donne la main
				}
				// deplacement 1 case devant pion rouge sans recule
				else if((Math.abs(caseDestination.x - caseInit.x)==1)&&(Math.abs(caseDestination.y - caseInit.y)==0)
						&&(caseInit.x>caseDestination.x)&&(Echiquier.cases[caseInit.x][caseInit.y].P.isBlue == false)
						&&(Echiquier.cases[caseDestination.x][caseDestination.y].P == null)){
					caseDestination.P = new Pion(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
					caseDestination.P.isBlue = isBlue;
					caseInit.P = null;
					echecEtMat(Echiquier);
					this.Echiquier.changeTour();		// donne la main
				}
				// deplacement 1 case diagonal pion Bleu sans recule
				else if((Math.abs(caseDestination.x - caseInit.x)==1)&&(Math.abs(caseDestination.y - caseInit.y)==1)
						&&(caseInit.x<caseDestination.x)&&(Echiquier.cases[caseInit.x][caseInit.y].P.isBlue == true)
						&&(Echiquier.cases[caseDestination.x][caseDestination.y].P != null)){
					caseDestination.P = new Pion(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
					caseDestination.P.isBlue = isBlue;
					caseInit.P = null;
					this.Echiquier.changeTour();		// donne la main
					echecEtMat(Echiquier);
				}
				// deplacement 1 case diagonal pion Rouge sans recule
				else if((Math.abs(caseDestination.x - caseInit.x)==1)&&(Math.abs(caseDestination.y - caseInit.y)==1)
						&&(caseInit.x>caseDestination.x)&&(Echiquier.cases[caseInit.x][caseInit.y].P.isBlue == false)
						&&(Echiquier.cases[caseDestination.x][caseDestination.y].P != null)){
					caseDestination.P = new Pion(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
					caseDestination.P.isBlue = isBlue;
					caseInit.P = null;
					echecEtMat(Echiquier);
					this.Echiquier.changeTour();		// donne la main
				}
				
				// deplacement 2 case devant si vide sans recule
				else if((Math.abs(caseInit.x - caseDestination.x)==2)&&(Math.abs(caseInit.y - caseDestination.y)==0)){
					
					// deplacement pion Bleu
					if(((caseInit.x - caseDestination.x)== -2)&&(caseInit.x<caseDestination.x)&&(Echiquier.cases[caseInit.x][caseInit.y].P.isBlue == true)){
						for(int i=caseInit.x+1; i<=caseDestination.x; i++){
							if(Echiquier.cases[i][caseInit.y].P != null){
								Libre = false;
								i = caseDestination.x;
							}
						}
						if(Libre){
							caseDestination.P = new Pion(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
							caseDestination.P.isBlue = isBlue;
							caseInit.P = null;
							echecEtMat(Echiquier);
							this.Echiquier.changeTour();		// donne la main
						}
					}
					// deplacement pion Rouge
					else if(((caseInit.x - caseDestination.x)== 2)&&(caseInit.x>caseDestination.x)&&(Echiquier.cases[caseInit.x][caseInit.y].P.isBlue == false)){
						for(int i=caseInit.x-1; i>=caseDestination.x; i--){
							if(Echiquier.cases[i][caseInit.y].P != null){
								Libre = false;
								i = caseDestination.x;
							}
						}
						if(Libre){
							caseDestination.P = new Pion(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
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
}
