/*___________________________________________________________*/
/*___________________________________________________________*/
/**
 * Fichier : ChampFlottant.java
 *
 * cr�� le : 5 nov. 2009 � 19:58:23
 *
 * Auteur : Jean-Louis IMBERT
 */
package champs;


/*___________________________________________________________*/
/**
 *
 */
public class ChampFlottant extends ChampSimple
{
	/** La valeur par d�faut.*/
	private float valeurPardefaut = 0 ;
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @param contenu Le contenu du champ.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampFlottant(String name, String contenu)
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
	public ChampFlottant(String name, String contenu, float valeurParDefaut)
			throws IllegalArgumentException
	{
		super(name, contenu);
		setValeurPardefaut(valeurParDefaut) ;
	}
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampFlottant(String name) throws IllegalArgumentException
	{
		this(name,VIDE,0);
	}
	/*___________________________________________________________*/
	/** Permet d'obtenir la valeur par d�faut.
	 * @return La valeur par d�faut.
	 */
	public float getValeurPardefaut()
	{
		return valeurPardefaut;
	}

	/*___________________________________________________________*/
	/** Modifie la valeur par d�faut.
	 * @param valeurPardefaut La valeur par d�faut.
	 */
	public void setValeurPardefaut(float valeurPardefaut)
	{
		this.valeurPardefaut = valeurPardefaut;
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
				Float val = new Float(contenu) ;
				if (val.floatValue()==valeurPardefaut)
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
	public float getValeur()
	{
		return (getContenu()==VIDE ? 
					valeurPardefaut : 
					Float.parseFloat(getContenu())) ;
	}
}

/*___________________________________________________________*/
/* Fin du fichier ChampFlottant.java. 
/*___________________________________________________________*/