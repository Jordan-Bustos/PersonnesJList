/**
 * @author jobustos
 */
package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import javax.swing.JOptionPane;

import Service.Persistance;
import metier.Personne;
import metier.BDDPersonnes;
import champs.Champ;
import champs.ChampEntier;
import champs.ChampFirstMajuscule;
import champs.ChampMajuscule;

/**
 * @author jobustos
 *
 */
public class Modele extends Observable implements Constantes{

	/** les champs.*/
	private Map<String,Champ> lesChamps = new HashMap<String, Champ>();
	
	/** les hobies. */
	private Map<String, Boolean> lesHobies = new HashMap<>();
	
	/** le modele de la liste.*/
	private ModeleListe modeleListe ;

	/** l'index du focus. */
	private int focus;

	/** la personne en cours */
	private Personne personne = null ;

	/**
	 * Constructeur du modele;
	 */
	public Modele (ModeleListe modeleListe){
		initialiserListeChamps();
		initialiserHobies();
		this.modeleListe=modeleListe;
	}

	/**
	 * Permet d'initialiser les hobies.
	 */
	private void initialiserHobies() {
		lesHobies.put(BASKETBALL, false);
		lesHobies.put(FOOTBALL, false);
		lesHobies.put(SOCCER, false);
		lesHobies.put(RUGBY, false);
		lesHobies.put(LECTURE, false);
		lesHobies.put(MUSIQUE, false);
	}
	


	/**
	 * Permet d'initialiser la liste des champs.
	 */
	private void initialiserListeChamps() {
		lesChamps.put(NOM, new ChampMajuscule(NOM));
		lesChamps.put(PRENOM, new ChampFirstMajuscule(PRENOM));
		lesChamps.put(AGE, new ChampEntier(AGE));
		lesChamps.put(CIVILITE, new ChampFirstMajuscule(CIVILITE));
		lesChamps.get(CIVILITE).setContenu(M);
	}

	/**
	 * Permet d'informer les observateurs.
	 * @param info l'info a divulger.
	 */
	private void informer(String info){
		setChanged();
		notifyObservers(info);
	}

	/**
	 * Permet de modifier un champ.
	 * @param name le nom du champ.
	 * @param text le contenu du champ.
	 */
	public void modifierChamp(String name, String text) {

		try{
			lesChamps.get(name).setContenu(text);
			informer(name);
		}
		catch (Exception e){
			warningMessage(e.getMessage(),name);
			viderChamp(name);
			placerFocus(name);
		}
	}
	
	/**
	 * Permet de vider tous les champs.
	 */
	public void netoyerChamps() {
		viderChamps();		
	}

	/**
	 * Permet de vider tous les champs.
	 */
	private void viderChamps() {
		viderChamp(NOM);
		viderChamp(PRENOM);
		viderChamp(AGE);
		modifierChamp(CIVILITE, M);
		viderHobies();
	}
	
	/**
	 * Permet de vider les hobies.
	 */
	private void viderHobies() {
		lesHobies.put(BASKETBALL, false);
		lesHobies.put(FOOTBALL, false);
		lesHobies.put(SOCCER, false);
		lesHobies.put(RUGBY, false);
		lesHobies.put(LECTURE, false);
		lesHobies.put(MUSIQUE, false);
		setChanged();
		notifyObservers(HOBIE);
	}

	/**
	 * Permet de vider un champ.
	 * @param name le nom du champ a vider.
	 */
	private void viderChamp(String name) {
		lesChamps.get(name).setContenu(VIDE);
		informer(name);
	}

	/**
	 * permet d'afficher un message d'erreur.
	 * @param name le nom de l'erreur.
	 */
	private void warningMessage(String message, String name) {

		JOptionPane.showMessageDialog(null, message ,name, JOptionPane.WARNING_MESSAGE);

	}

	/**
	 * Permet d'ajouter une personne.
	 */
	public void ajouterPersonne() {

		if ((getTextOfChamp(NOM).equals(VIDE))
				|| (getTextOfChamp(PRENOM).equals(VIDE))
				|| (getTextOfChamp(AGE).equals(VIDE)))
			warningMessage("Veuillez remplir tous les champs", ERREUR_AJOUT);

		else
		{
			try{
				if (personne!=null)
				{
					BDDPersonnes.getInstance().deletePersonne(personne);
				}
				
				List<String> hobies = getHobies();			
				
				Personne p = new Personne ( getTextOfChamp(CIVILITE),
											getTextOfChamp(NOM),
											getTextOfChamp(PRENOM),
											Integer.parseInt((getTextOfChamp(AGE))),
											hobies );
				
				BDDPersonnes.getInstance().addPersonne(p);

				mettreAJourListePersonnes();
				viderChamps();
			
			}
			catch(Exception e){
				warningMessage(e.getMessage(), ERREUR_AJOUT);
			}
		}
	}

	/**
	 * Permet d'obtenir le contenu du champ.
	 * @param name le nom du champ.
	 * @return le contenu du champ.
	 */
	public String getTextOfChamp (String name){
		return lesChamps.get(name).getContenu();
	}

	/**
	 * Permet d'incrementer le focus.
	 */
	public void focusSuivant() {
		focus = (focus+1)%3;
		informer(FOCUS);		
	}

	/**
	 * Permet d'obtenir le nom de l'element qui a le focus.
	 * @return
	 */
	public String getFocus() {
		String nameChamp = null ;
		if (focus==0)
			nameChamp = NOM ;
		else if (focus==1)
			nameChamp = PRENOM ;
		else if (focus==2)
			nameChamp =  AGE ;
		return nameChamp;
	}

	/**
	 * Permet de positionner le focus sur un champ.
	 * @param name le nom du champ.
	 */
	public void placerFocus(String name) {
		if (name.equals(NOM))
			focus=0;
		else if(name.equals(PRENOM))
			focus=1;
		else if(name.equals(AGE))
			focus=2;
		informer(FOCUS);
	}

	/**
	 * Pemet de modifier la personne en cours.
	 * @param index l'index de la personne dans la liste.
	 */
	public void setPersonne(int index) {
		personne = modeleListe.getElementAt(index);

		modifierChamp(CIVILITE, personne.getCivilite()) ;
		modifierChamp(NOM,personne.getNom());
		modifierChamp(PRENOM,personne.getPrenom());
		modifierChamp(AGE,String.valueOf(personne.getAge()));
		modifierHobies(personne);
	}

	/**
	 * Permet de modifier les hobies de la personne en cours.
	 * @param personne la personne en cours.
	 */
	private void modifierHobies(Personne personne) {
		for (String hobie : lesHobies.keySet())
		{
			if(personne.getHobies().contains(hobie))
				lesHobies.put(hobie, true);
			else
				lesHobies.put(hobie,false);
		}
		setChanged();
		notifyObservers(HOBIE);
	}

	/**
	 * Permet de mettre a jouer la liste des personnes.
	 */
	private void mettreAJourListePersonnes() {
		setChanged();
		modeleListe.mettreAJour();
	}

	/**
	 * Permet d'ajouter ou enlever une hobie.
	 * @param name le nom de la hobie.
	 * @param selected 
	 */
	public void setHobie(String name, boolean selected) {
		lesHobies.put(name,selected);
	}
	
	/**
	 * Permet d'obtenir la liste des hobies coches.
	 * @return la liste des hobies coches.
	 */
	private List<String> getHobies () {
		List<String> hobies = new ArrayList<>();
		for(String hob : lesHobies.keySet())
			if (lesHobies.get(hob))
				hobies.add(hob);
		return hobies;
	}
	
	/**
	 * Permet de retourner si la hobie est coche ou non.
	 * @param hobie la hobie souhaite.
	 * @return true si la hobie est coche, false sinon.
	 */
	public boolean getHobie (String hobie) 
	{
		return lesHobies.get(hobie);
	}

	/**
	 * Permet de quitter l'application.
	 */
	public void quitter() {

		int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter ?" , "Attention", JOptionPane.WARNING_MESSAGE);
		if (rep == JOptionPane.OK_OPTION)
		{
			setChanged();
			notifyObservers(QUITTER);
		}
		
	}

	/**
	 * Permet de sauvegarder.
	 */
	public void sauvegarder() {

		Persistance.getInstance().sauvegarder() ;		
	}

	/**
	 * Permet de charger.
	 */
	public void charger() {
		
		Persistance.getInstance().charger() ;
		mettreAJourListePersonnes() ;
	}
	

	

}
