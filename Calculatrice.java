package calculus;
/**
* Author
* Fabrice Ngahadjo
* Kaleo Chase
* Eloy 	Alvear
*/ 

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Calculatrice extends JFrame {
	private static final long serialVersionUID = 1L;

	public Calculatrice(){
		this.setSize(240, 260);
		this.setTitle("Calculus");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		initComposant();
		this.setVisible(true);
	}

	private void initComposant(){
		Controleur controleur = new Controleur();
		
		Modele modele = new Modele();
		View view = new View();
		
		controleur.setModele(modele);
		controleur.setView(view);
		
		this.getContentPane().add(view, BorderLayout.NORTH);
		this.getContentPane().add(controleur.getChiffre(), BorderLayout.CENTER);
		this.getContentPane().add(controleur.getOperateur(), BorderLayout.EAST);
	}
}
