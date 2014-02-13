/*________________________________________________________*/
/**
 * Fichier : ChampSimple.java
 *
 * cr�� le 16 oct. 2011 � 07:02:30
 *
 * Auteur : Jean-Louis IMBERT
 */
package champs;


/*________________________________________________________*/
/** Repr�sente le cas le plus simple de Champ. 
 *La m�thode setContenu supprime uniquement les blancs commen�ants 
 *et finissants, et met � la cha�ne vide les cha�ne <code>null</code>.
 */
public class ChampSimple implements Champ
{
	/** constante de vide. */
	public static final String VIDE = "" ;
	/** Le nom du champ. */
	private String name ;
	/** Le contenu du champ.*/
	private String contenu = VIDE ;
	/** Indique si le champ doit �tre obligatoirement rempli.*/
	private boolean obligatoire = false ;
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @param contenu Le contenu du champ.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampSimple(String name, String contenu)
	throws IllegalArgumentException
	{
		setName(name) ;
		setContenu(contenu) ;
	}
	/*___________________________________________________________*/
	/** Cr�ation du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	public ChampSimple(String name)
	throws IllegalArgumentException
	{
		this(name, VIDE) ;
	}
	/*___________________________________________________________*/
	/** Permet d'obtenir le nom du champ.
	 * @return Le nom du champ.
	 */
	public String getName()
	{
		return name;
	}
	/*___________________________________________________________*/
	/** Modifie le nom du champ.
	 * @param name Le nom du champ. Il ne peut �tre vide.
	 * @throws IllegalArgumentException Si le nom du champ est 
	 * 		<code>null</code> ou vide.
	 */
	private void setName(String name)
	throws IllegalArgumentException
	{
		if (name==null || name.trim().length()==0)
			throw new IllegalArgumentException("le nom " +
					"du champ n'est pas d�fini.") ;
		this.name = name.trim() ;
	}
	/*___________________________________________________________*/
	/** Permet d'obtenir le contenu du champ.
	 * @return Le contenu du champ.
	 */
	public String getContenu()
	{
		return contenu;
	}
	/*___________________________________________________________*/
	/** Modifie le contenu du champ.
	 * @param contenu Le contenu du champ.
	 */
	public void setContenu(String contenu)
	{
		if (contenu==null) contenu = VIDE ;
		this.contenu = contenu.trim() ;
	}
	/*________________________________________________________*/
	/** Indique si le champ est vide.
	 * @return <code>true</code> si le champ est vide, <code>false</code>
	 * 		sinon.
	 */
	public boolean isEmpty()
	{
		return contenu==VIDE ;
	}
	/*________________________________________________________*/
	/** Indique si le champ doit �tre obligatoirement rempli.
	 * @return <code>true</code> si le champ doit �tre 
	 * 		obligatoirement rempli, <code>false</code> sinon.
	 * @see coucheApplicative.mvc.champs.Champ#estObligatoire()
	 */
	@Override
	public boolean estObligatoire()
	{
		return obligatoire;
	}
	/*________________________________________________________*/
	/** Modifie l'obligation de rempli ce champ.
	 * @param obligatoire <code>true</code> pour rempli le champ obligatoire, 
	 * 		<code>false</code> sinon.
	 * @see coucheApplicative.mvc.champs.Champ#setObligatoire(boolean)
	 */
	@Override
	public void setObligatoire(boolean obligatoire)
	{
		this.obligatoire = obligatoire;
	}
	/*________________________________________________________*/
}

/*________________________________________________________*/
/* Fin du fichier ChampSimple.java
/*________________________________________________________*/