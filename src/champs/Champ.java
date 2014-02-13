/*___________________________________________________________*/
/*___________________________________________________________*/
/**
 * Fichier : Champ.java
 *
 * cr�� le : 4 nov. 2009 � 21:46:38
 *
 * Auteur : Jean-Louis IMBERT
 */
package champs;

/*___________________________________________________________*/
/**
 * Repr�sente un champ g�n�ral.
 */
public interface Champ
{
	/** constante de vide. */
	public static String VIDE = "" ;
	/*___________________________________________________________*/
	/** Permet d'obtenir le nom du champ.
	 * @return Le nom du champ.
	 */
	public String getName() ;
	/*___________________________________________________________*/
	/** Permet d'obtenir le contenu du champ.
	 * @return Le contenu du champ.
	 */
	public String getContenu() ;
	/*___________________________________________________________*/
	/** Modifie le contenu du champ.
	 * @param contenu Le contenu du champ.
	 */
	public void setContenu(String contenu) ;
	/*________________________________________________________*/
	/** Indique si le champ est vide.
	 * @return <code>true</code> si le champ est vide, <code>false</code>
	 * 		sinon.
	 */
	public boolean isEmpty() ;
	/*________________________________________________________*/
	/** Indique si le champ doit �tre obligatoirement rempli.
	 * @return <code>true</code> si le champ doit �tre 
	 * 		obligatoirement rempli, <code>false</code> sinon.
	 */
	public boolean estObligatoire() ;
	/*________________________________________________________*/
	/** Modifie l'obligation de rempli ce champ.
	 * @param bool <code>true</code> pour rempli le champ obligatoire, 
	 * 		<code>false</code> sinon.
	 */
	public void setObligatoire(boolean bool);
}

/*___________________________________________________________*/
/* Fin du fichier Champ.java. 
/*___________________________________________________________*/