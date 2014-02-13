/*___________________________________________________________*/
/*___________________________________________________________*/
/**
 * Fichier : ChampDate.java
 *
 * cr�� le : 4 nov. 2009 � 23:44:39
 *
 * Auteur : Jean-Louis IMBERT
 */
package champs;

import java.util.Calendar;
import java.util.GregorianCalendar;


/*___________________________________________________________*/
/**
 * Les dates acceptables sont �crites sous la forme :
 * "jj/mm/aaaa".
 */
public class ChampDate extends ChampSimple
{
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @param contenu Le contenu du champ.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampDate(String name, String contenu)
			throws IllegalArgumentException
	{
		super(name, contenu);
	}
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampDate(String name) throws IllegalArgumentException
	{
		super(name);
	}
	/*___________________________________________________________*/
	/** Modifie le contenu du champ.
	 * @param contenu Le contenu du champ.
	 */
	public void setContenu(String contenu)
	{
		boolean correct = true ;
		if (contenu==null) contenu = VIDE ;
		try
		{
			contenu = contenu.trim();
			if (contenu!=VIDE)
			{
				GregorianCalendar date = getdate(contenu) ;
				contenu = String.format("%1$td/%1$tm/%1$tY", date) ;
			}
		} catch (Exception e)
		{
			contenu = VIDE ;
			correct = false ;
		}
		super.setContenu(contenu) ;
		if (!correct)
		{
			String message = "La date est incorrect : (jj/mm/aaaa) ou vide si inconnue." ;
			throw new IllegalArgumentException(message);
		}
	}
	/*___________________________________________________________*/
	/** Transforme une cha�ne de caract�res en GregorianCalendar.
	 * @param date La date � transformer.
	 * @return La date correspondant � la cha�ne de caract�res
	 * 		donn�e en param�tre.
	 */
	private GregorianCalendar getdate(String date)
	{
		String[] tab = date.split("/") ;
		if (tab.length!=3)
			throw new IllegalArgumentException("date incorrecte. Format accept� : jj/mm/aaaa") ;
		int jour = Integer.parseInt(tab[0]) ;
		int mois = Integer.parseInt(tab[1])-1 ;
		int annee = Integer.parseInt(tab[2]) ;
		GregorianCalendar gc = new GregorianCalendar(annee, mois, jour) ;
		if (gc.get(Calendar.DAY_OF_MONTH)!=jour ||
			gc.get(Calendar.MONTH)!=mois ||
			gc.get(Calendar.YEAR)!=annee)
			throw new IllegalArgumentException("date non valide. Ecrire \"jj/mm/aaaa\"") ;
		return gc ;
	}
	/*___________________________________________________________*/
	/** Retourne la date.
	 * @return La date, ou null si elle est inconnue.
	 */
	public GregorianCalendar getValeur()
	{
		if (getContenu()==VIDE)
			return null ;
		else return getdate(getContenu()) ;
	}
}

/*___________________________________________________________*/
/* Fin du fichier ChampDate.java. 
/*___________________________________________________________*/