package TP5_Leopold_Aziz_GUEYE_et_Fama_Ndiaye;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
//la classe echiquier est une fenetre (JFrame) qui contient un damier lui-meme constitue de 8X8 cases
//un label "etiquette" qui indique qui doit jouer enfin le booleen tour est vrai lorsque c'est le tour des bleus
//et faux lorsque c'est le tour des rouges. L'echiquier implemente l'ecouteur d'actions pour r�cuperer
//les evenements sur le menu que l'on va cr�er

class Echiquier extends JFrame implements ActionListener {
 public Case cases[][]; 
 private JPanel damier;
 protected JLabel etiquette;
 private boolean tour;
 
 public Echiquier(){
	setPreferredSize(new Dimension(480,480)); 
	setBackground(Color.darkGray);
		
	// setLayout permet de choisir la politique de placement des objets graphiques dans un conteneur
	// ici la fen�tre on choisi un FlowLayout : les �l�ments sont dispos�s les uns � la suite des autres
	setLayout(new FlowLayout());
	
	// on choisit de tuer l'application lorsque l'on clique sur la croix
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	// cr�ation d'une barre de menu avec un menu appel� "menu" dans ce menu, on a deux choix
	// "Start" pour commencer une partie "Quitter" pour quitter l'application
	JMenuBar menubar=new JMenuBar();
	JMenu menu=new JMenu("Menu");	
	JMenuItem it1=new JMenuItem("Start");
	JMenuItem it2=new JMenuItem("Quitter");
	
	// Lorsque l'on clique sur l'item Start, on d�clenche une action appel�e "Start"
	it1.setActionCommand("Start");	
	it2.setActionCommand("Quitter");
	
	// ajout des items au menu
	menu.add(it1);
	menu.add(it2);	    
	
	// ajout du menu a la barre de menu
	menubar.add(menu);
	
	// Les �v�nements sur les items seront �cout�s par l'�chiquier
	it1.addActionListener(this);	
	it2.addActionListener(this);
	
	// on affecte la barre de menu � la fen�tre Echiquier
	setJMenuBar(menubar);
	
	// on cr�e une zone de dessin "damier" avec une politique de placement en grille 8X8
	// cette zone contiendra les 8X8 cases 	
	damier=new JPanel(new GridLayout(8,8,0,0));
	damier.setSize(500,500);
	etiquette=new JLabel("Aucune partie en cours");
	
	// on cr�e un tableau de cases 8X8
	cases=new Case[8][8];	
	
	// on alterne les couleurs pour obtenir un damier chaque case est ajout�e au damier
	// grace � la politique de placement des objets les 8 premiers case seront plac�es sur 
	// la premi�re ligne du damier, etc.
	for(int i=0;i<8;i++)
	    for(int j=0;j<8;j++){
			if((i+j)%2==0)
			    cases[i][j]=new Case(Color.lightGray,this,i,j,null);
			else
			    cases[i][j]=new Case(Color.WHITE,this,i,j,null);
			// ajout de la case cr�e sur le damier
			damier.add(cases[i][j]);
	    }
	
	// on ins�re le damier dans la fen�tre
	add(damier);
	// on ins�re le label dans la fen�tre
	add(etiquette);
 }
 
 // fonction qui r�cup�re les actions ici les actions correspondent aux �v�nements
 // sur les items du menu

 public void actionPerformed(ActionEvent e){	
	// Si on clique sur Quitter alors on tue l'application
	if(e.getActionCommand().equals("Quitter"))
	    System.exit(0);
	else // Sinon, on a clique sur "Start" et on cr�e une nouvelle partie
	    NouvellePartie();
 }

 public boolean getTour(){
	return tour;
 }
 
 public void changeTour(){ 
	// change le bool�en tour et met a jour l'�tiquette
	tour=!tour;
	if(tour)
	    etiquette.setText("Autour des bleus");
	else
	    etiquette.setText("Autour des rouges");
 }
 
 private void NouvellePartie(){
	// cr�ation d'une nouvelle partie, on affiche "Autour des bleus"
	etiquette.setText("Autour des bleus");
	// les bleus commencent donc, tour est initialis� a vrai
	tour=true;
	
	// on supprime les pi�ces de la partie pr�cedente
	for(int i=0;i<8;i++)	
	    for(int j=0;j<8;j++)
	    	cases[i][j].P=null;
	
	// on place les pi�ces	
	for(int i=0;i<8;i++){
	    cases[1][i].P=new Pion(this,cases[1][i],true);
	    cases[1][i].P.isBlue = true;
	}
	for(int i=0;i<8;i++)
	    cases[6][i].P=new Pion(this,cases[6][i],false);
	
	cases[0][4].P=new Roi(this,cases[0][4],true);
	cases[0][4].P.isBlue = true;
	cases[7][4].P=new Roi(this,cases[7][4],false);
	
	cases[0][0].P=new Tour(this,cases[0][0],true);
	cases[0][0].P.isBlue = true;
	cases[0][7].P=new Tour(this,cases[0][7],true);
	cases[0][7].P.isBlue = true;
	
	cases[7][0].P=new Tour(this,cases[7][0],false);
	cases[7][7].P=new Tour(this,cases[7][7],false);
	
	cases[0][2].P=new Fou(this,cases[0][2],true);
	cases[0][2].P.isBlue = true;
	cases[0][5].P=new Fou(this,cases[0][5],true);
	cases[0][5].P.isBlue = true;
	
	cases[7][2].P=new Fou(this,cases[7][2],false);
	cases[7][5].P=new Fou(this,cases[7][5],false);
	
	cases[0][1].P=new Cavalier(this,cases[0][1],true);
	cases[0][1].P.isBlue = true;
	cases[0][6].P=new Cavalier(this,cases[0][6],true);
	cases[0][6].P.isBlue = true;
	
	cases[7][1].P=new Cavalier(this,cases[7][1],false);
	cases[7][6].P=new Cavalier(this,cases[7][6],false);
	
	
	cases[0][3].P=new Reine(this,cases[0][3],true);
	cases[0][3].P.isBlue = true;
	cases[7][3].P=new Reine(this,cases[7][3],false);
	
		
	// une fois toutes les pi�ces plac�es, on rafraichit l'affichage
	// la partie commence !
	repaint();
 }
}
