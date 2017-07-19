package TP5_Leopold_Aziz_GUEYE_et_Fama_Ndiaye;

import javax.swing.JLabel;

public class Roi extends Piece{
	
	private Echiquier Echiquier;
	private Case LaCase;
	private boolean Deplacement;
	
	public Roi(){}
	
	public Roi(Echiquier echiquier, Case laCase, boolean deplacement){
		this.Echiquier = echiquier;
		this.LaCase = laCase;
		this.Deplacement = deplacement;
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	@Override
	public void moveTo(Case caseInit, Case caseDestination) {
		if(this.Echiquier.getTour() == this.Deplacement){
			// deplacement possible que si la case de destination est vide 
			// ou si la case est occupé, on s'assure que c'est le jeton adverse		
			if((caseDestination.P == null)||((caseDestination.P != null)&&(caseDestination.P.isBlue != caseInit.P.isBlue))){
				// on verifie que le deplacement de 1 case est respecté
				if(((Math.abs(caseDestination.x - caseInit.x)==0)||(Math.abs(caseDestination.x - caseInit.x)==1))
						&&((Math.abs(caseDestination.y - caseInit.y)==0)||(Math.abs(caseDestination.y - caseInit.y)==1))){
					
					caseDestination.P = new Roi(this.Echiquier,this.Echiquier.cases[caseDestination.x][caseDestination.y],this.Deplacement);
					caseDestination.P.isBlue = isBlue;		
					caseInit.P = null;
					echecEtMat(Echiquier);
					this.Echiquier.changeTour();		// donne la main
				}
			}
		}
	}
}
