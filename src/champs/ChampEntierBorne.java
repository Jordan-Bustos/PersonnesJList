/*___________________________________________________________*/
/*___________________________________________________________*/
/**
 * Fichier : ChampEntierBorne.java
 *
 * cr�� le : 4 nov. 2009 � 23:25:02
 *
 * Auteur : Jean-Louis IMBERT
 */
package champs;

import java.util.*;


/*___________________________________________________________*/
/**
 * Gestion des entiers born�s. Un tel champ est compos� d'un 
 * intervalle d'entiers, plus une valeur par d�faut qui n'est 
 * pas forc�ment dans l'intervalle, ainsi que des valeurs 
 * acceptables autres que celles de l'intervalle.
 * 
 * Les bornes de l'intervalles doivent �tre introduites par 
 * les m�thodes <code>setBorneInf</code> et 
 * <code>setBorneSup</code>, et les valeurs acceptables autres 
 * que celles de l'intervalle sont introduites par la m�thode
 * <code>addValeurAcceptee(int)</code>.
 */
public class ChampEntierBorne extends ChampEntier
{
	/** Borne inf�rieure. */
	private int borneInf ;
	/** Borne sup�rieure. */
	private int borneSup ;
	/** Liste des valeurs accept�es. */
	private Set<Integer> entiersAcceptes = new TreeSet<Integer>() ;
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @param contenu Le contenu du champ.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampEntierBorne(String name, String contenu)
			throws IllegalArgumentException
	{
		super(name, contenu);
	}
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @param contenu Le contenu du champ.
	 * @param valeurParDefaut La valeur par d�faut.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampEntierBorne(String name, String contenu, int valeurParDefaut)
			throws IllegalArgumentException
	{
		super(name, contenu, valeurParDefaut);
	}
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampEntierBorne(String name) throws IllegalArgumentException
	{
		super(name);
	}
	/*___________________________________________________________*/
	/** Permet d'obtenir la borne inf�rieure.
	 * @return La borne inf�rieure.
	 */
	public int getBorneInf()
	{
		return borneInf;
	}

	/*___________________________________________________________*/
	/** Modifie la borne inf�rieure.
	 * @param borneInf La nouvelle borne inf�rieure.
	 */
	public void setBorneInf(int borneInf)
	{
		this.borneInf = borneInf;
	}

	/*___________________________________________________________*/
	/** Permet d'obtenir la borne sup�rieure.
	 * @return La borne sup�rieure.
	 */
	public int getBorneSup()
	{
		return borneSup;
	}

	/*___________________________________________________________*/
	/** Modifie la borne sup�rieure.
	 * @param borneSup La nouvelle borne sup�rieure.
	 */
	public void setBorneSup(int borneSup)
	{
		this.borneSup = borneSup;
	}
	/*___________________________________________________________*/
	/** Ajoute une valeur accept�e. Les valeurs accept�es n'ont 
	 * d'int�r�t que si elles sont hors des bornes de valeurs 
	 * acceptables.
	 * @param val Une valeur accept�e.
	 */
	public void addValeurAcceptee(int val)
	{
		entiersAcceptes.add(new Integer(val)) ;
	}
	/*___________________________________________________________*/
	/** Modifie le contenu du champ. 
	 * @param contenu Le contenu du champ.
	 * @throws IllegalArgumentException Si la valeur est incorrecte;
	 */
	public void setContenu(String contenu)
	throws IllegalArgumentException
	{
		super.setContenu(contenu) ;
		int val = getValeur() ;
		if (val!=getValeurParDefaut() && (val<borneInf || val>borneSup))
		{
			Integer entier = new Integer(val) ;
			if (!entiersAcceptes.contains(entier))
			{
				super.setContenu(VIDE) ;
				throw new IllegalArgumentException(
						String.format("Valeur incorrecte. entre %d et %d, " +
								"ou vide si inconnu", borneInf, borneSup)) ;
			}
		}
	}
	/*___________________________________________________________*/
	/** Permet d'obtenir l'ensemble des entiers accept�s.
	 * @return L'ensemble des entiers accept�s.
	 */
	public String getEntiersAcceptes()
	{
		StringBuffer texte = new StringBuffer();
		boolean first = true ;
		for (Integer i : entiersAcceptes)
		{
			if (first) first = false ;
			else texte.append(", ") ;
			texte.append(i);
		}
		return texte.toString();
	}
}

/*___________________________________________________________*/
/* Fin du fichier ChampEntierBorne.java. 
/*___________________________________________________________*/