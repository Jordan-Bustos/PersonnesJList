/*___________________________________________________________*/
/*___________________________________________________________*/
/**
 * Fichier : ChampEnumereEntier.java
 *
 * cr�� le : 8 nov. 2009 � 15:42:26
 *
 * Auteur : Jean-Louis IMBERT
 */
package champs;

import java.util.List;


/*___________________________________________________________*/
/**
 * Permet de g�rer des valeurs appartenant � un ensemble discret
 * d'entiers. Les valeurs acceptables sont les seules valeurs
 * pass�es � l'objet dans le constructeur sous la forme d'un
 * tableau d'entiers.
 */
public class ChampEnumereEntier extends ChampEntierBorne
{
	/*___________________________________________________________*/
	/** Constructeur de l'objet <code>ChampEnumereEntier</code>.
	 * @param name Le nom du champ.
	 * @param valeursAutorisees  Le tableau des valeurs enti�res 
	 * autoris�es.
	 * @param valeurParDefaut La valeur par d�faut.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampEnumereEntier(String name, int[] valeursAutorisees, int valeurParDefaut)
			throws IllegalArgumentException
	{
		super(name, VIDE, valeurParDefaut);
		setBorneInf(valeurParDefaut) ;
		setBorneSup(valeurParDefaut) ;
		for (int i : valeursAutorisees)
			addValeurAcceptee(i) ;
		setContenu(Integer.toString(valeurParDefaut)) ;
	}
	/*___________________________________________________________*/
	/** Constructeur de l'objet <code>ChampEnumereEntier</code>.
	 * La valeur par d�faut sera la premi�re valeur du tableau
	 * des valeurs autoris�es.
	 * @param name Le nom du champ.
	 * @param valeursAutorisees  Le tableau des valeurs enti�res 
	 * autoris�es.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampEnumereEntier(String name, int[] valeursAutorisees)
			throws IllegalArgumentException
	{
		this(name, valeursAutorisees, valeursAutorisees[0]);
	}
	/*___________________________________________________________*/
	/** Constructeur de l'objet <code>ChampEnumereEntier</code>.
	 * La valeur par d�faut sera la premi�re valeur du tableau
	 * des valeurs autoris�es.
	 * @param name Le nom du champ.
	 * @param valeursAutorisees  Le tableau des valeurs enti�res 
	 * autoris�es.
	 * @param valeurParDefaut La valeur par d�faut.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampEnumereEntier(String name, List<Integer> valeursAutorisees, int valeurParDefaut)
			throws IllegalArgumentException
	{
		super(name, VIDE, valeurParDefaut);
		setBorneInf(valeurParDefaut) ;
		setBorneSup(valeurParDefaut) ;
		for (int i : valeursAutorisees)
			addValeurAcceptee(i) ;
		setContenu(Integer.toString(valeurParDefaut)) ;
	}
	/*___________________________________________________________*/
	/** Modifie le contenu du champ.
	 * @param contenu Le contenu du champ.
	 */
	public void setContenu(String contenu)
	{
		try {super.setContenu(contenu);}
		catch (IllegalArgumentException e) 
		{
			throw new IllegalArgumentException("Valeur incorrect. " +
					"valeurs acceptables : "+getEntiersAcceptes()) ;
		}
	}
}

/*___________________________________________________________*/
/* Fin du fichier ChampEnumereEntier.java. 
/*___________________________________________________________*/