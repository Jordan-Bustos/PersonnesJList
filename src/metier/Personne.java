/**
 * @author jobustos
 */
package metier;

import java.io.Serializable;
import java.util.List;

/**
 * @author jobustos
 *
 */
public class Personne implements Comparable<Personne>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1010318091468392471L;


	/** Le nom de la personne.*/
	private String nom ;

	/** Le prenom de la personne.*/
	private String prenom ;

	/** L'age de la personne.*/
	private int age ;
	
	/** civilite de la personne. */
	private String civilite;
	
	/** les hobies de la personne. */
	private List<String> hobies ;
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the civilite
	 */
	public String getCivilite() {
		return civilite;
	}
	
	/**
	 * 
	 * @return les hobies.
	 */
	public List<String> getHobies() {
		return hobies;
	}
	
	/**
	 * Setteur de l'age.
	 * @param age le nouvel age.
	 * @throws IllegalArgumentException Si l'age n'est pas compris entre 1 et 105 ans.
	 */
	private void setAge(int age)
		throws IllegalArgumentException
	{
		if (age<1 || age>105)
			throw new IllegalArgumentException("L'age doit etre compris entre 1 et 105 ans");
		this.age = age ;		
	}

	/**
	 * Setteur du prenom.
	 * @param prenom le nouveau prenom.
	 * @throws IllegalArgumentException si la taille du prenom est inferieur a 3.
	 * @throws NullPointerException si le prenom est null.
	 */
	private void setPrenom(String prenom)
			throws IllegalArgumentException , NullPointerException
	{
		if (prenom==null)
			throw new NullPointerException("Le prenom est null");
		prenom = prenom.trim();
		if (prenom.length()<3)
			throw new IllegalArgumentException("La taille du prenom doit etre superieur a 3 caracteres");
		this.prenom = prenom;
	}

	/**
	 * Setteur du nom.
	 * @param nom le nouveau nom.
	 * @throws IllegalArgumentException si la taille du nom est inferieur a 3.
	 * @throws NullPointerException si le nom est null.
	 */
	private void setNom(String nom) 
		throws IllegalArgumentException , NullPointerException
	{
		if (nom==null)
			throw new NullPointerException("Le nom est null");
		nom = nom.trim();
		if (nom.length()<3)
			throw new IllegalArgumentException("La taille du nom doit etre superieur a 3 caracteres");
		this.nom = nom;
	}
	
	/**
	 * Permet de setter la civilite.
	 * @param civilite la civilite de la personne.
	 * @throws IllegalArgumentException si la civilite est null.
	 */
	private void setCivilite(String civilite)
			throws IllegalArgumentException 
	{
		if (civilite==null)
			throw new NullPointerException("Civilite ne doit pas etre null");
		civilite=civilite.toString();
		this.civilite=civilite;
	}

	/**
	 * 
	 * @param hobies
	 */
	private void setHobies (List<String> hobies) {
		this.hobies = hobies ;
	}
	
	/**
	 * Constructeur complet d'une personne.
	 * @param civilite la civilite de la personne.
	 * @param nom le nom de la personne.
	 * @param prenom le prenom de la personne.
	 * @param age l'age de la personne.
	 */
	public Personne (String civilite, String nom, String prenom, int age, List<String> hobies) 
		throws IllegalArgumentException , NullPointerException
	{
		setCivilite(civilite);
		setNom(nom);
		setPrenom(prenom);
		setAge(age);
		setHobies(hobies);
	}
	
	
	@Override
	public int hashCode(){
		return ( (nom.hashCode()*13 + prenom.hashCode())*17 + (age*111 + civilite.hashCode()*12)*107 );
	}

	@Override
	public int compareTo(Personne p) {
		
		if(p.nom.equals(nom))
		{
			if(p.prenom.equals(prenom))
			{
				if(p.age==age)
				{
					return 0;
				}
				else
				{
					if (p.age-age<0)
						return -1;
					else
						return 1;
				}
			}
			else
			{
				return prenom.compareTo(p.prenom);
			}
		}
		else
		{
			return nom.compareTo(p.nom);
		}
	}
	
	@Override
	public boolean equals(Object o){
		boolean ok = false ;
		Personne p = (Personne) o;
		
		if (p!=null){
			if(  (p.civilite.equals(civilite)) && (p.nom.equals(nom)) && (p.prenom.equals(prenom)) && ((p.age==age)) ) 
							ok = true;
		}
		
		return ok;
		
	}

	@Override
	public String toString(){
		StringBuilder build = new StringBuilder();
		build.append(civilite).append(" ").append(nom).append(" ").append(prenom).append(" ").append(age);	
		return build.toString();
	}
	
}