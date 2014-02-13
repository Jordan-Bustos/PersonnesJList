/**
 * @author jobustos
 */
package application;

import javax.swing.AbstractListModel;

import metier.Personne;
import metier.BDDPersonnes;

/**
 * @author jobustos
 *
 */
public class ModeleListe extends AbstractListModel<Personne> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	@Override
	public Personne getElementAt(int index) {
		return BDDPersonnes.getInstance().getPersonne(index);
	}
	

	/* (non-Javadoc)
	 * @see javax.swing.ListModel#getSize()
	 */
	@Override
	public int getSize() {
		return BDDPersonnes.getInstance().getSize();
	}
	
	/**
	 * Permet de mettre a jour la JList.
	 */
	public void mettreAJour(){
		fireContentsChanged(this, 0, getSize());
	}

}
