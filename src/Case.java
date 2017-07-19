package TP5_Leopold_Aziz_GUEYE_et_Fama_Ndiaye;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
//La classe Case gére les cases du damier
//l'attribut couleur donne la couleur de base de la case : grise ou blanche 
//la case change de couleur lorsque l'on clique dessus 
//ou lorsqu'elle est survolée par la souris avec le clique enclenché
//elle reprend sa couleur d'origine lorsque l'on relache le clique ou que la souris quitte la case
//le booléen click est vrai si la souris a cliqué sur la case
//le booléen clicked permet de savoir si le click est enclenché
//l'attribut E contient une réference vers l'échiquier 
//l'attribut P contient une réference vers une piéce 
//si la case est occupée par une piéce
//les attributs x et y sont les coordonnées de la case dans le damier
//l'attribut destination sauvegarde la réference de la case vers laquelle on souhaite déplacer un pion
//Case hérite de JPanel qui est une sorte d'aire de dessin
//Case implémente Mouselistener: l'écouteur de souris 
//pour récuperer les événements dus à la souris 

class Case extends JPanel implements MouseListener{ 
	 private final Color couleur;
	 private boolean click;
	 private static boolean clicked=false;
	 public final Echiquier E;
	 public Piece P;
	 public int x, y;
	 private static Case destination=null;
	  
	
	 
 public Case(Color c, Echiquier E, int x, int y, Piece P){
	// setBackground affecte la couleur de fond
 	setBackground(c);	
	// setPreferredSize et setSize permettent de fixer les dimensions de la case
	setPreferredSize(new Dimension(50,50)); 
	setSize(getPreferredSize());
	// les événements souris sur la case sont écoutés par la case elle-méme
	addMouseListener(this);
	
	couleur=c;
	click=false;
	this.E=E;
	this.x=x;
	this.y=y;
	this.P=P;
 }

// cette fonction remet la case à sa couleur d'origine
 public void ResetColor(){
	setBackground(couleur);
 }
 
 // comme la case écoute les événements souris sur elle-méme
 // elle doit implementer les fonctions suivantes lorsqu'on enclenche le clique sur la case
 public void mousePressed(MouseEvent e){
	click=true; // la case se souvient que la souris a cliqué sur elle
	clicked=true; // on informe les autres cases que le clique est enclenché
	setBackground(Color.green);  // on change la couleur de la case
     // on sauvegarde la référence de la case que la souris survole actuellement avec le clique enclenche
	destination=this; 
 }
 
 // événement "sur clique" non utilisé
 public void mouseClicked(MouseEvent e) {}
 
 // lorsqu'on entre dans une case avec le clique enclenché
 public void mouseEntered(MouseEvent e) {
	if(!click && clicked) setBackground(Color.cyan); // on change la couleur 
	if( clicked)  destination=this; // et on met à jour la destination
 }
 
 // événement lorsqu'on relache le clique 
 // cet événement est capté par la case qui a subit le clique
 // c'est pourquoi on a besoin de la variable destination
 // elle permet de savoir ou est la souris lorsque le clique est relï¿½chï¿½
 public void mouseReleased(MouseEvent e) {
	// on remet la couleur d'origine de la case
	ResetColor();
	
	click=false;
	clicked=false;
	
	// on remet la couleur d'origine de la case destination
	destination.ResetColor();
	
	// si la case d'origine contient une piece 
	// on essaie de bouger cette piéce vers la case destination
	// ce déplacement réussit si on respecte les contraintes
	
	//javax.swing.JOptionPane.showMessageDialog(null,"Ton message"); 
	
	if(P!=null)
	    P.moveTo(this, destination);
 }
 

 // événement sur sortie de la souris d'une case
 public void mouseExited(MouseEvent e) {
	if(!click) ResetColor();
 }
 
 // la méthode paintComponent gére l'affichage de la case 
 public void paintComponent(Graphics g){
	// on affiche d'abord la case
    	super.paintComponent(g); 
	
	// puis on affiche la piece à l'interieur
	// si la case contient une piece
	if(P!=null){
	    if(P.isBlue)
	    	g.setColor(Color.blue);
	    else
	    	g.setColor(Color.red);
	    
	    Font f = new Font("Comic sans MS",Font.BOLD,20);
	    g.setFont(f);
	    g.drawString(P.toString(),20,30);
	}
 }
 
}
