/*___________________________________________________________*/
/*___________________________________________________________*/
/**
 * Fichier : ChampFlottantBorne.java
 *
 * cr�� le : 5 nov. 2009 � 20:01:40
 *
 * Auteur : Jean-Louis IMBERT
 */
package champs;

import java.util.HashSet;
import java.util.Set;


/*___________________________________________________________*/
/**
 * Gestion des flottants born�s. Un tel champ est compos� d'un 
 * intervalle de flottants, plus une valeur par d�faut qui n'est 
 * pas forc�ment dans l'intervalle, ainsi que des valeurs 
 * acceptables autres que celles de l'intervalle.
 * 
 * Les bornes de l'intervalles doivent �tre introduites par 
 * les m�thodes <code>setBorneInf</code> et 
 * <code>setBorneSup</code>, et les valeurs acceptables autres 
 * que celles de l'intervalle sont introduites par la m�thode
 * <code>addValeurAcceptee(float)</code>.
 */
public class ChampFlottantBorne extends ChampFlottant
{
	/** Borne inf�rieure. */
	private float borneInf ;
	/** Borne sup�rieure. */
	private float borneSup ;
	/** Liste des valeurs accept�es. */
	private Set<Float> flottantsAcceptes = new HashSet<Float>() ;
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @param contenu Le contenu du champ.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampFlottantBorne(String name, String contenu)
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
	public ChampFlottantBorne(String name, String contenu, float valeurParDefaut)
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
	public ChampFlottantBorne(String name) throws IllegalArgumentException
	{
		super(name);
	}
	/*___________________________________________________________*/
	/** Permet d'obtenir la borne inf�rieure.
	 * @return La borne inf�rieure.
	 */
	public float getBorneInf()
	{
		return borneInf;
	}

	/*___________________________________________________________*/
	/** Modifie la borne inf�rieure.
	 * @param borneInf La nouvelle borne inf�rieure.
	 */
	public void setBorneInf(float borneInf)
	{
		this.borneInf = borneInf;
	}

	/*___________________________________________________________*/
	/** Permet d'obtenir la borne sup�rieure.
	 * @return La borne sup�rieure.
	 */
	public float getBorneSup()
	{
		return borneSup;
	}

	/*___________________________________________________________*/
	/** Modifie la borne sup�rieure.
	 * @param borneSup La nouvelle borne sup�rieure.
	 */
	public void setBorneSup(float borneSup)
	{
		this.borneSup = borneSup;
	}
	/*___________________________________________________________*/
	/** Ajoute une valeur accept�e. Les valeurs accept�es n'ont 
	 * d'int�r�t que si elles sont hors des bornes de valeurs 
	 * acceptables.
	 * @param val Une valeur accept�e.
	 */
	public void addValeurAcceptee(float val)
	{
		flottantsAcceptes.add(new Float(val)) ;
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
		float val = getValeur() ;
		if (val!=getValeurPardefaut() && (val<borneInf || val>borneSup))
		{
			Float flottant = new Float(val) ;
			if (!flottantsAcceptes.contains(flottant))
			{
				super.setContenu(VIDE) ;
				throw new IllegalArgumentException(
						String.format("Valeur incorrecte. entre %f et %f, " +
								"ou vide si inconnu", borneInf, borneSup)) ;
			}
		}
	}
}

/*___________________________________________________________*/
/* Fin du fichier ChampFlottantBorne.java. 
/*___________________________________________________________*/