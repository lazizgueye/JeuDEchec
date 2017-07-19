package TP5_Leopold_Aziz_GUEYE_et_Fama_Ndiaye;

import javax.swing.JLabel;

public class Cavalier extends Piece{
	
	private Echiquier Echiquier;
	private Case LaCase;
	private boolean Deplacement;

	public Cavalier(Echiquier echiquier, Case laCase, boolean deplacement){
		this.Echiquier = echiquier;
		this.LaCase = laCase;
		this.Deplacement = deplacement;
	}
	
	@Override
	public String toString() {
		return "C";
	}
	
	@Override
	public void moveTo(Case caseInit, Case caseDestination) {		
		if(this.Echiquier.getTour() == this.Deplacement){
			//deplacement possible que si la case de destination est vide
			// ou, si la case est occupé, on s'assure que c'est le jeton adverse
			if((caseDestination.P == null)||((caseDestination.P != null)&&(caseDestination.P.isBlue != caseInit.P.isBlue))){
				// deplacement vertical de 2 cases, puis virer à gauche ou droite
				if((Math.abs(caseDestination.x - caseInit.x) == 2)&&(Math.abs(caseDestination.y - caseInit.y) == 1)){
					caseDestination.P = new Cavalier(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
					caseDestination.P.isBlue = isBlue;		
					caseInit.P = null;
					this.Echiquier.changeTour();		// donne la main
				}
				// deplacement horizontal de 2 cases, puis virer à gauche ou droite
				else if((Math.abs(caseDestination.x - caseInit.x) == 1)&&(Math.abs(caseDestination.y - caseInit.y) == 2)){
					caseDestination.P = new Cavalier(this.Echiquier,Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
					caseDestination.P.isBlue = isBlue;		
					caseInit.P = null;
					this.Echiquier.changeTour();		// donne la main
				}
			}
		}
	}
}
