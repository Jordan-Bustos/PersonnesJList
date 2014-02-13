/**
 * @author jobustos
 */
package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author jobustos
 *
 */
public class BDDPersonnes {
	
	/** instance unique.*/
	private static BDDPersonnes instance;
	
	/** la liste des personnes. */
	private SortedSet<Personne> liste ;
	
	/**
	 * Contructeur prive.
	 */
	private BDDPersonnes(){
		
		liste = new TreeSet<>();
		
	}
	
	/**
	 * Permet d'obtenir l'instance de Personnes.
	 * @return l'instance de Personnes.
	 */
	public static BDDPersonnes getInstance(){
		if (instance==null)
			instance = new BDDPersonnes();
		return instance;
	}
	
	/**
	 * Permet d'ajouter une personne a la liste.
	 * @param personne la personne a ajouter.
	 */
	public void addPersonne(Personne personne){
		liste.add(personne);
	}
	
	/**
	 * Permet de supprimer une personne de la liste. 
	 * @param personne la personne a supprimer.
	 */
	public void deletePersonne(Personne personne){
		liste.remove(personne);
	}
	
	/**
	 * Permet de retourner la personne de l'index selectionne.
	 * @param index l'index selectionne.
	 * @return la personne de l'index selectionne.
	 */
	public Personne getPersonne(int index){
		List<Personne> tmpListe = new ArrayList<>(liste);
		return tmpListe.get(index);		
	}

	/**
	 * Permet de retourner la taille de la liste.
	 * @return la taille de la liste.
	 */
	public int getSize() {
		return liste.size();
	}
	
	/**
	 * Permet d'ajouter une liste de personnes.
	 * @param personnes
	 */
	public void addPersonnes (SortedSet<Personne> personnes) {
		liste.addAll(personnes);
	}
	
	/**
	 * Permet de revoyer la liste des personnes connues.
	 * @return la liste des personnes connues.
	 */
	public SortedSet<Personne> getPersonnesConnues(){
		return liste ;
	}
	

}
