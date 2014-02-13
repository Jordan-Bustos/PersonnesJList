/**
 * 
 */
package Service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.SortedSet;

import javax.swing.JFileChooser;

import metier.Personne;
import metier.BDDPersonnes;
import application.Constantes;

/**
 * @author Jodan Bustos
 * 
 * Classe de service.
 */
public class Persistance implements Constantes {
	
	/** instance unique de la classe de service. */
	private static Persistance instance ; 
	
	/**
	 * Constructeur prive.
	 */
	private Persistance (){} ;
	
	/**
	 * Permet d'obtenir l'instance unique de la classe de service.
	 * @return retourne l'instance unique de la classe de service.
	 */
	public static Persistance getInstance () {
		if (instance == null)
			instance = new Persistance() ;
		return instance ;
	}
	
	/**
	 * Permet de sauvegarder la liste des personnes connues.
	 */
	public void sauvegarder () {
		
		JFileChooser chooser = new JFileChooser();
		File rep = new File ("./save");
		rep.mkdirs();
		chooser.setCurrentDirectory(rep);
		chooser.setFileFilter(new FiltreFichier());
		
		int choix = chooser.showSaveDialog(null) ;
		File fichier = null ;
		
		if (choix == JFileChooser.APPROVE_OPTION)
		{
			fichier = chooser.getSelectedFile();
			if (fichier != null)
				save(fichier);
		}

	}
	
	/**
	 * Permet de sauvagarder un fichier.
	 * @param fic le fichier a sauvegarder.
	 */
	private void save (File fic) {
		SortedSet<Personne> personnes = BDDPersonnes.getInstance().getPersonnesConnues();
		try
		{
			ObjectOutputStream sortie = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fic)));
			sortie.writeObject(personnes);
			sortie.close();
		} 
		catch (FileNotFoundException e) {
		} 
		catch (IOException e) {
		}
	}
	
	
	/**
	 * Permet de charger un fichier de personnes.
	 */
	public void charger () {

		JFileChooser chooser = new JFileChooser();
		File rep = new File ("./save");
		rep.mkdirs();
		chooser.setCurrentDirectory(rep);
		chooser.setFileFilter(new FiltreFichier());
		
		int choix = chooser.showDialog(null, CHARGER);
		File fichier = null ;
		
		if (choix == JFileChooser.APPROVE_OPTION)
		{
			fichier = chooser.getSelectedFile();
			if (fichier != null)
				load(fichier);
		}
		
	}

	/**
	 * Permet de charger un fichier de personnes.
	 * @param fic le fichier de personnes.
	 */
	@SuppressWarnings("unchecked")
	private void load(File fic) {

		SortedSet<Personne> personnes = null ;
		try
		{
			ObjectInputStream entree = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fic)));
			personnes=(SortedSet<Personne>) entree.readObject();
			entree.close();
		} 
		catch (FileNotFoundException e) {
		} 
		catch (IOException e) {
		} 
		catch (ClassNotFoundException e) {
		}
		
		BDDPersonnes.getInstance().addPersonnes(personnes);
		
	}
		
	
	

}
