/**
 * @author jobustos
 */
package presentation;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import application.Constantes;
import application.Modele;
import application.ModeleListe;

/**
 * @author jobustos
 *
 */
public class FenPrincipale extends JFrame implements Constantes, Observer {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2439504742264872459L;

	/**
	 * Constructeur de la fenetre principale.
	 */
	public FenPrincipale (){
		setTitle(NOM_FENETRE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,350);
		
		ModeleListe modeleListe = new ModeleListe();
		Modele modele = new Modele(modeleListe);
		Controleur controleur = new Controleur(modele);
		
		modele.addObserver(this);
		
		
		setContentPane(new Vue(controleur,modele,modeleListe));	
		setJMenuBar(new MenuBar(controleur));
		
		setLocationRelativeTo(null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FenPrincipale fen = new FenPrincipale();
		fen.setVisible(true);

	}

	@Override
	public void update(Observable source, Object info) {
		
		if (source instanceof Modele) 
		{
			if (info.toString().equals(QUITTER))
			{
				dispose();
			}
		}
		
	}





}
