package TP5_Leopold_Aziz_GUEYE_et_Fama_Ndiaye;

import java.awt.Color;
import javax.swing.JLabel;

public abstract class Piece extends Echiquier{
	
	protected static Piece P;
	//protected Case LaCase;
	protected Color LaCouleur;
	public boolean Deplacement;
	//public Case Destination;
	//protected Echiquier Echiquier;
	public boolean isBlue = false;
	
	public Piece(){};
	
	public Piece(Color couleur, boolean deplacement){
		super();
		this.LaCouleur = couleur;
		this.Deplacement = deplacement;
		//this.Echiquier = echiquier;
	}
		
	public abstract void moveTo(Case caseInit, Case caseDestination);		
	public abstract String toString();

	//javax.swing.JOptionPane.showMessageDialog(null,""+ Echiquier.getTour());*
	
	public void echecEtMat(Echiquier echiquier){
		Piece R = new Roi();
		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				//Roi Bleu
				if((echiquier.cases[i][j].P instanceof Roi)&&(echiquier.cases[i][j].P.isBlue == true)
						&&(echiquier.getTour()==true)){
					//javax.swing.JOptionPane.showMessageDialog(null,echiquier.cases[i][j].P+" bleu i:"+i+", j:"+j);
					//accessible pion, Fou, Reine deplacement 1	X
						if((i+1<8)&&(j-1>=0)&&(echiquier.cases[i+1][j-1].P != null)&&((echiquier.cases[i+1][j-1].P instanceof Pion)||(echiquier.cases[i+1][j-1].P instanceof Fou)||(echiquier.cases[i+1][j-1].P instanceof Reine))&&(echiquier.cases[i+1][j-1].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((i+1<8)&&(j+1<8)&&(echiquier.cases[i+1][j+1].P != null)&&((echiquier.cases[i+1][j+1].P instanceof Pion)||(echiquier.cases[i+1][j+1].P instanceof Fou)||(echiquier.cases[i+1][j+1].P instanceof Reine))&&(echiquier.cases[i+1][j+1].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");	
					//accessible Fou, Reine deplacement 2 X
						for(int m=j-1,k=i-1; k>=0; k--){// X gauch haut
							if((k>=0)&&(m>=0)&&(echiquier.cases[k][m].P != null)&&((echiquier.cases[k][m].P instanceof Fou)||(echiquier.cases[k][m].P instanceof Reine))&&(echiquier.cases[k][m].P.isBlue == false)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=0;
							}
							else if(echiquier.cases[k][m].P != null){
								k=0;
							}
							if(m>0)
								m--;
						}
						for(int m=j-1,k=i+1; k<8; k++){// X gauch bas
							if((k<8)&&(m>=0)&&(echiquier.cases[k][m].P != null)&&((echiquier.cases[k][m].P instanceof Fou)||(echiquier.cases[k][m].P instanceof Reine))&&(echiquier.cases[k][m].P.isBlue == false)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=8;
							}
							else if(echiquier.cases[k][m].P != null){
								k=8;
							}
							if(m>0)
								m--;
						}
						for(int m=j+1,k=i-1; k>=0; k--){// X droite haut
							if((k>=0)&&(m<8)&&(echiquier.cases[k][m].P != null)&&((echiquier.cases[k][m].P instanceof Fou)||(echiquier.cases[k][m].P instanceof Reine))&&(echiquier.cases[k][m].P.isBlue == false)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=0;
							}
							else if(echiquier.cases[k][m].P != null){
								k=0;
							}
							if(m<8)
								m++;
						}
						/*for(int m=j+1,k=i+1; k<8; k++){// X droite bas
							if((k<8)&&(m<8)&&(echiquier.cases[k][m].P != null)&&((echiquier.cases[k][m].P instanceof Fou)||(echiquier.cases[k][m].P instanceof Reine))&&(echiquier.cases[k][m].P.isBlue == false)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=8;
							}
							else if(echiquier.cases[k][m].P != null){
								k=8;
							}
							if(m<8)
								m++;
						}*/
					//accessible Tour, Reine deplacement 1 +
						if((j-1>=0)&&(echiquier.cases[i][j-1].P != null)&&((echiquier.cases[i][j-1].P instanceof Tour)||(echiquier.cases[i][j-1].P instanceof Reine))&&(echiquier.cases[i][j-1].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((j-1<8)&&(echiquier.cases[i][j+1].P != null)&&((echiquier.cases[i][j+1].P instanceof Tour)||(echiquier.cases[i][j+1].P instanceof Reine))&&(echiquier.cases[i][j+1].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");	
						else if((i-1>=0)&&(echiquier.cases[i-1][j].P != null)&&((echiquier.cases[i-1][j].P instanceof Tour)||(echiquier.cases[i-1][j].P instanceof Reine))&&(echiquier.cases[i-1][j].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((i+1<8)&&(echiquier.cases[i+1][j].P != null)&&((echiquier.cases[i+1][j].P instanceof Tour)||(echiquier.cases[i+1][j].P instanceof Reine))&&(echiquier.cases[i+1][j].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
					//accessible Tour, Reine deplacement 2 +
						for(int k=j-1; k>=0; k--){// gauche
							if((k>=0)&&(echiquier.cases[i][k].P != null)&&((echiquier.cases[i][k].P instanceof Tour)||(echiquier.cases[i][k].P instanceof Reine))&&(echiquier.cases[i][k].P.isBlue == false)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=0;
							}
							else if(echiquier.cases[i][k].P != null)
								k = 0;
						}
						for(int k=j+1; k<8; k++){//droite
							if((k<8)&&(echiquier.cases[i][k].P != null)&&((echiquier.cases[i][k].P instanceof Tour)||(echiquier.cases[i][k].P instanceof Reine))&&(echiquier.cases[i][k].P.isBlue == false)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=8;
							}
							else if(echiquier.cases[i][k].P != null)
								k=8;
						}
						for(int k=i-1; k>=0; k--){//Haut
							if((k>=0)&&(echiquier.cases[k][j].P != null)&&((echiquier.cases[k][j].P instanceof Tour)||(echiquier.cases[k][i].P instanceof Reine))&&(echiquier.cases[k][i].P.isBlue == false)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=0;
							}
							else if(echiquier.cases[k][j].P != null)
								k=0;
						}
						for(int k=i+1; k<8; k++){//bas
							if((k<8)&&(echiquier.cases[k][j].P != null)&&((echiquier.cases[k][j].P instanceof Tour)||(echiquier.cases[k][i].P instanceof Reine))&&(echiquier.cases[k][i].P.isBlue == false)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=8;
							}
							else if(echiquier.cases[k][j].P != null)
								k=8;
						}
					//accessible Cavalier deplacement 1
						if((i-1>=0)&&(j-2>=0)&&(echiquier.cases[i-1][j-2].P != null)&&(echiquier.cases[i-1][j-2].P instanceof Cavalier)&&(echiquier.cases[i-1][j-2].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((i-1>=0)&&(j+2<8)&&(echiquier.cases[i-1][j+2].P != null)&&(echiquier.cases[i-1][j+2].P instanceof Cavalier)&&(echiquier.cases[i-1][j+2].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
						else if((i+1<8)&&(j-2>=0)&&(echiquier.cases[i+1][j-2].P != null)&&(echiquier.cases[i+1][j-2].P instanceof Cavalier)&&(echiquier.cases[i+1][j-2].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((i+1<8)&&(j+2<8)&&(echiquier.cases[i+1][j+2].P != null)&&(echiquier.cases[i+1][j+2].P instanceof Cavalier)&&(echiquier.cases[i+1][j+2].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
						else if((i+2<8)&&(j-1>=0)&&(echiquier.cases[i+2][j-1].P != null)&&(echiquier.cases[i+2][j-1].P instanceof Cavalier)&&(echiquier.cases[i+2][j-1].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((i+2<8)&&(j+1<8)&&(echiquier.cases[i+2][j+1].P != null)&&(echiquier.cases[i+2][j+1].P instanceof Cavalier)&&(echiquier.cases[i+2][j+1].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
						else if((i-2>=0)&&(j-1>=0)&&(echiquier.cases[i-2][j-1].P != null)&&(echiquier.cases[i-2][j-1].P instanceof Cavalier)&&(echiquier.cases[i-2][j-1].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((i-2>=0)&&(j+1<8)&&(echiquier.cases[i-2][j+1].P != null)&&(echiquier.cases[i-2][j+1].P instanceof Cavalier)&&(echiquier.cases[i-2][j+1].P.isBlue == false))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
				}
				//Roi Rouge
				else if((echiquier.cases[i][j].P instanceof Roi)&&(echiquier.cases[i][j].P.isBlue == false)
						&&(echiquier.getTour()==false)){
					//accessible pion, Fou, Reine deplacement 1 X	
						if((i-1>=0)&&(j-1>=0)&&(echiquier.cases[i-1][j-1].P != null)&&((echiquier.cases[i-1][j-1].P instanceof Pion)||(echiquier.cases[i-1][j-1].P instanceof Fou)||(echiquier.cases[i-1][j-1].P instanceof Reine))&&(echiquier.cases[i-1][j-1].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						if((i-1>=0)&&(j+1<8)&&(echiquier.cases[i-1][j+1].P != null)&&((echiquier.cases[i-1][j+1].P instanceof Pion)||(echiquier.cases[i-1][j+1].P instanceof Fou)||(echiquier.cases[i-1][j+1].P instanceof Reine))&&(echiquier.cases[i-1][j+1].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
					//accessible Tour, Reine deplacement 1 +
						if((j-1>=0)&&(echiquier.cases[i][j-1].P != null)&&((echiquier.cases[i][j-1].P instanceof Tour)||(echiquier.cases[i][j-1].P instanceof Reine))&&(echiquier.cases[i][j-1].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((j+1<8)&&(echiquier.cases[i][j+1].P != null)&&((echiquier.cases[i][j+1].P instanceof Tour)||(echiquier.cases[i][j+1].P instanceof Reine))&&(echiquier.cases[i][j+1].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");	
						else if((i-1>=0)&&(echiquier.cases[i-1][j].P != null)&&((echiquier.cases[i-1][j].P instanceof Tour)||(echiquier.cases[i-1][j].P instanceof Reine))&&(echiquier.cases[i-1][j].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((i+1<8)&&(echiquier.cases[i+1][j].P != null)&&((echiquier.cases[i+1][j].P instanceof Tour)||(echiquier.cases[i+1][j].P instanceof Reine))&&(echiquier.cases[i+1][j].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
					//accessible Tour, Reine deplacement 2 +
						for(int k=j-1; k>=0; k--){// gauche
							if((k>=0)&&(echiquier.cases[i][k].P != null)&&((echiquier.cases[i][k].P instanceof Tour)||(echiquier.cases[i][k].P instanceof Reine))&&(echiquier.cases[i][k].P.isBlue == true)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=0;
							}
							else if(echiquier.cases[i][k].P != null)
								k = 0;
						}
						for(int k=j+1; k<8; k++){//droite
							if((k<8)&&(echiquier.cases[i][k].P != null)&&((echiquier.cases[i][k].P instanceof Tour)||(echiquier.cases[i][k].P instanceof Reine))&&(echiquier.cases[i][k].P.isBlue == true)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=8;
							}
							else if(echiquier.cases[i][k].P != null)
								k=8;
						}
						for(int k=i-1; k>=0; k--){//Haut
							if((k>=0)&&(echiquier.cases[k][j].P != null)&&((echiquier.cases[k][j].P instanceof Tour)||(echiquier.cases[k][j].P instanceof Reine))&&(echiquier.cases[k][j].P.isBlue == true)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=0;
							}
							else if(echiquier.cases[k][j].P != null)
								k=0;
						}
						for(int k=i+1; k<8; k++){//bas
							if((k<8)&&(echiquier.cases[k][j].P != null)&&((echiquier.cases[k][j].P instanceof Tour)||(echiquier.cases[k][j].P instanceof Reine))&&(echiquier.cases[k][j].P.isBlue == true)){
								javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
								k=8;
							}
							else if(echiquier.cases[k][j].P != null)
								k=8;
						}
					//accessible Cavalier deplacement 1
						if((i-1>=0)&&(j-2>=0)&&(echiquier.cases[i-1][j-2].P != null)&&(echiquier.cases[i-1][j-2].P instanceof Cavalier)&&(echiquier.cases[i-1][j-2].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((i-1>=0)&&(j+2<8)&&(echiquier.cases[i-1][j+2].P != null)&&(echiquier.cases[i-1][j+2].P instanceof Cavalier)&&(echiquier.cases[i-1][j+2].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
						else if((i+1<8)&&(j-2>=0)&&(echiquier.cases[i+1][j-2].P != null)&&(echiquier.cases[i+1][j-2].P instanceof Cavalier)&&(echiquier.cases[i+1][j-2].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((i+1<8)&&(j+2<8)&&(echiquier.cases[i+1][j+2].P != null)&&(echiquier.cases[i+1][j+2].P instanceof Cavalier)&&(echiquier.cases[i+1][j+2].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
						else if((i+2<8)&&(j-1>=0)&&(echiquier.cases[i+2][j-1].P != null)&&(echiquier.cases[i+2][j-1].P instanceof Cavalier)&&(echiquier.cases[i+2][j-1].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((i+2<8)&&(j+1<8)&&(echiquier.cases[i+2][j+1].P != null)&&(echiquier.cases[i+2][j+1].P instanceof Cavalier)&&(echiquier.cases[i+2][j+1].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
						else if((i-2>=0)&&(j-1>=0)&&(echiquier.cases[i-2][j-1].P != null)&&(echiquier.cases[i-2][j-1].P instanceof Cavalier)&&(echiquier.cases[i-2][j-1].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");		
						else if((i-2>=0)&&(j+1<8)&&(echiquier.cases[i-2][j+1].P != null)&&(echiquier.cases[i-2][j+1].P instanceof Cavalier)&&(echiquier.cases[i-2][j+1].P.isBlue == true))
							javax.swing.JOptionPane.showMessageDialog(null,"echec et mat");
				}	
			}
		}
	}
	
	public String RStr(){
		return "R";
	}

}

