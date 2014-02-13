/*___________________________________________________________*/
/*___________________________________________________________*/
/**
 * Fichier : ChampEntier.java
 *
 * cr�� le : 4 nov. 2009 � 22:58:01
 *
 * Auteur : Jean-Louis IMBERT
 */
package champs;


/*___________________________________________________________*/
/**
 * Gestion des entiers.
 */
public class ChampEntier extends ChampSimple
{
	/** La valeur par d�faut.*/
	private int valeurParDefaut = 0 ;
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @param contenu Le contenu du champ.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampEntier(String name, String contenu)
			throws IllegalArgumentException
	{
		this(name, contenu, 0);
	}
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @param contenu Le contenu du champ.
	 * @param valeurParDefaut La valeur par d�faut.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampEntier(String name, String contenu, int valeurParDefaut)
			throws IllegalArgumentException
	{
		super(name, contenu);
		setValeurParDefaut(valeurParDefaut) ;
	}
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampEntier(String name) throws IllegalArgumentException
	{
		this(name,VIDE,0);
	}
	/*___________________________________________________________*/
	/** Permet d'obtenir la valeur par d�faut.
	 * @return La valeur par d�faut.
	 */
	public int getValeurParDefaut()
	{
		return valeurParDefaut;
	}

	/*___________________________________________________________*/
	/** Modifie la valeur par d�faut.
	 * @param valeurParDefaut La valeur par d�faut.
	 */
	public void setValeurParDefaut(int valeurParDefaut)
	{
		this.valeurParDefaut = valeurParDefaut;
	}
	/*___________________________________________________________*/
	/** Modifie le contenu du champ. 
	 * @param contenu Le contenu du champ.
	 * @throws IllegalArgumentException Si la valeur est incorrecte;
	 */
	public void setContenu(String contenu)
	throws IllegalArgumentException
	{
		boolean correct = true ;
		if (contenu==null || contenu.trim().length()==0)
		{
			contenu = VIDE ;
		}
		else
		{
			contenu = contenu.trim() ;
			try
			{
				Integer val = new Integer(contenu) ;
				if (val.intValue()==valeurParDefaut)
					contenu = VIDE;
				else contenu = val.toString() ;
			} catch (Exception e) 
			{
				contenu = VIDE ;
				correct = false ;
			}
		}
		super.setContenu(contenu) ;
		if (!correct) 
			throw new IllegalArgumentException("Ce n'est pas un entier acceptable.") ;
	}
	/*___________________________________________________________*/
	/** Retourne la valeur du champ.
	 * @return La valeur du champ.
	 */
	public int getValeur()
	{
		return (getContenu()==VIDE ? 
					valeurParDefaut : 
					Integer.parseInt(getContenu())) ;
	}
}

/*___________________________________________________________*/
/* Fin du fichier ChampEntier.java. 
/*___________________________________________________________*/