/*___________________________________________________________*/
/*___________________________________________________________*/
/**
 * Fichier : ChampEnumereChaine.java
 *
 * cr�� le : 25 nov. 2009 � 19:27:30
 *
 * Auteur : Jean-Louis IMBERT
 */
package champs;

import java.util.Set;
import java.util.TreeSet;


/*___________________________________________________________*/
/**
 * Cette classe permet de g�rer des champs de texte faisant 
 * partie d'un ensemble de cha�nes pr�d�fini.
 */
public class ChampEnumereChaine extends ChampSimple
{
	/** La liste des valeurs accept�es. */
	private Set<String> valeursAcceptes = new TreeSet<String>() ;
	/** La valeur par d�faut.*/
	private String valeurParDefaut ;
	/*___________________________________________________________*/
	/** Constructeur complet.
	 * @param name le nom du champ.
	 * @param valeursAcceptes L'ensemble des champs accept�s.
	 * @param valeurParDefaut  La valeur par d�faut, si non d�fini 
	 * 		ou si une valeur non autoris�e est donn�e par la
	 * 		m�thode setContenu.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide, ou si une valeur non
	 * 		accept�e est donn�e.
	 */
	public ChampEnumereChaine(String name, String[] valeursAcceptes, 
			String valeurParDefaut) throws IllegalArgumentException
	{
		super(name);
		setValeursAcceptee(valeursAcceptes) ;
		setValeurParDefaut(valeurParDefaut) ;
	}
	/*___________________________________________________________*/
	/** Constructeur complet.
	 * @param name le nom du champ.
	 * @param valeursAcceptes L'ensemble des champs accept�s.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide, ou si une valeur non
	 * 		accept�e est donn�e.
	 */
	public ChampEnumereChaine(String name, String[] valeursAcceptes) 
	throws IllegalArgumentException
	{
		this(name, valeursAcceptes,VIDE) ;
	}
	/*___________________________________________________________*/
	/** Modifie la liste des valeurs accept�es.
	 * @param valeursAcceptes La liste des valeurs accept�es.
	 */
	private void setValeursAcceptee(String[] valeursAcceptes)
	{
		for (String val : valeursAcceptes)
			this.valeursAcceptes.add(val) ;
	}
	/*___________________________________________________________*/
	/** Modifie la valeur par d�faut.
	 * @param valeurParDefaut La valeur par d�faut.
	 */
	private void setValeurParDefaut(String valeurParDefaut)
	{
		this.valeurParDefaut = valeurParDefaut ;
		setContenu(valeurParDefaut) ;
	}
	/*___________________________________________________________*/
	/** Modifie le contenu du champ.
	 * @param contenu Le contenu du champ.
	 */
	public void setContenu(String contenu)
	{
		if (valeursAcceptes==null)
			return ;
		if (contenu==null) contenu = VIDE ;
		else contenu = contenu.trim() ;
		if (valeursAcceptes.contains(contenu)) 
			super.setContenu(contenu) ;
		else if(!contenu.equals(valeurParDefaut))
		{
			super.setContenu(VIDE) ;
			throw new IllegalArgumentException("Valeur non reconnue.") ;
		}
	}
}

/*___________________________________________________________*/
/* Fin du fichier ChampEnumereChaine.java. 
/*___________________________________________________________*/