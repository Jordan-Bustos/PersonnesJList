/*___________________________________________________________*/
/*___________________________________________________________*/
/**
 * Fichier : ChampMajuscule.java
 *
 * cr�� le : 4 nov. 2009 � 21:55:46
 *
 * Auteur : Jean-Louis IMBERT
 */
package champs;


/*___________________________________________________________*/
/**
 * Le contenu du champ est mis en majuscule.
 */
public class ChampMajuscule extends ChampSimple
{
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @param contenu Le contenu du champ.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampMajuscule(String name, String contenu)
			throws IllegalArgumentException
	{
		super(name,contenu) ;
	}
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampMajuscule(String name)
			throws IllegalArgumentException
	{
		super(name);
	}
	/*___________________________________________________________*/
	/** Modifie le contenu du champ. Le contenu sera mis en 
	 * majuscule s'il n'y est pas d�j�.
	 * @param contenu Le contenu du champ.
	 */
	public void setContenu(String contenu)
	{
		if (contenu==null) contenu = VIDE ;
		super.setContenu(contenu.toUpperCase()) ;
	}
}

/*___________________________________________________________*/
/* Fin du fichier ChampMajuscule.java. 
/*___________________________________________________________*/