/*___________________________________________________________*/
/*___________________________________________________________*/
/**
 * Fichier : ChampFirstMajuscule.java
 *
 * cr�� le : 4 nov. 2009 � 22:02:50
 *
 * Auteur : Jean-Louis IMBERT
 */
package champs;


/*___________________________________________________________*/
/**
 * Les premi�res lettres des mots sont en majuscule, 
 * les autres en minuscules.
 */
public class ChampFirstMajuscule extends ChampSimple
{
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @param contenu Le contenu du champ.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampFirstMajuscule(String name, String contenu)
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
	public ChampFirstMajuscule(String name) throws IllegalArgumentException
	{
		super(name);
	}
	/*___________________________________________________________*/
	/** Modifie le contenu du champ. Les premi�res lettres des mots
	 * du contenu seront mise en 
	 * majuscule les autres en minuscule.
	 * @param contenu Le contenu du champ.
	 */
	public void setContenu(String contenu)
	{
		if (contenu==null) contenu = VIDE ;
		StringBuffer texte =  new StringBuffer(contenu.trim().toLowerCase()) ;
		boolean first = true ;
		for (int i=0; i<texte.length(); i++)
		{
			char ch = texte.charAt(i) ;
			if (first && Character.isLetter(ch))
			{
				texte.setCharAt(i, Character.toUpperCase(ch)) ;
				first = false ;
			}
			else if (!Character.isLetter(ch))
				first = true ;
		}
		super.setContenu(texte.toString()) ;
	}
}

/*___________________________________________________________*/
/* Fin du fichier ChampFirstMajuscule.java. 
/*___________________________________________________________*/