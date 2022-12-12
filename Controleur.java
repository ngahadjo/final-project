package calculus;
/* Authors 
 * Fabrice, Kaleo, and Eloy
 */
import java.awt.Component;

public class Controleur {
	private static final long serialVersionUID = 1L;
	Modele modele;
	View view;
	
	ControleurOperator jcoperateur;
	ControleurChiffre  jcchiffre;
	
	boolean clicOperateur = false;
	boolean update = false;
	private String operation = "";
	double nombre;

	public Controleur(){
		jcchiffre = new ControleurChiffre(this);
		jcoperateur = new ControleurOperator(this);        
	}
	//setters
	public void setModele(Modele modele){
		this.modele=modele;
	}
	
	public void setView(View view) {
		this.view=view;
	}
	//getters
	public Component getChiffre() {
		return jcchiffre;
	}
	
	public Component getOperateur() {
		return jcoperateur;
	}
	//Math functions 
	private void calcul(){
		if(operation.equals("+")) {
			nombre = nombre + modele.getDouble();
			changeValue(nombre);
		}
		if(operation.equals("-")) {
			nombre = nombre - modele.getDouble();
			changeValue(nombre);
		}               
		if(operation.equals("*")) {
			nombre = nombre * modele.getDouble();
			changeValue(nombre);
		}       
		if(operation.equals("/")) {
			try{
				nombre = nombre / modele.getDouble();
				changeValue(nombre);
			}catch(ArithmeticException e){
				changeValue(0);
			}
		}
	}	
	
	public void setChiffre(String str) {
		if(update){
			update = false;
		} else {
			if(!modele.getValue().equals("0")){
				if (str.equals(".") )
					if (modele.getValue().contains("."))
						str = modele.getValue();
					else
						str = modele.getValue() + str;
				else	
					str = modele.getValue() + str;
			}
		}
		changeValue(str);
	}
	// Equal function
	public void egal() {
		calcul();
		update = true;
		clicOperateur = false;
	}
	// Clear function
	public void raz() {
		clicOperateur = false;
		update = true;
		nombre = 0;
		operation = "";
		changeValue(nombre);
	}
	//Addition
	public void plus() {
		if(clicOperateur) {
			calcul();
			changeValue(nombre);
		} else {
			nombre = modele.getDouble();
			clicOperateur = true;
		}
		operation = "+";
		update = true;
	}
	//Subtraction
	public void moins() {
		if(clicOperateur) {
			calcul();
			changeValue(nombre);
		} else {
			nombre = modele.getDouble();
			clicOperateur = true;
		}
		operation = "-";
		update = true;
	}
	//Multiplication
	public void multiplier() {
		if(clicOperateur) {
			calcul();
			changeValue(nombre);
		} else {
			nombre = modele.getDouble();
			clicOperateur = true;
		}
		operation = "*";
		update = true;
	}
	//Division
	public void diviser() {
		if(clicOperateur) {
			calcul();
			changeValue(nombre);
		} else {
			nombre = modele.getDouble();
			clicOperateur = true;
		}
		operation = "/";
		update = true;
	}
	
	private void changeValue(double chiffre1) {
		modele.setValue(String.valueOf(chiffre1));
		view.setValue(modele.getValue());
	}
	
	private void changeValue(String chiffre) {
		modele.setValue(chiffre);
		view.setValue(modele.getValue());
	}
}
