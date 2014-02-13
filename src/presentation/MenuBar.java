/**
 * 
 */
package presentation;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import application.Constantes;

/**
 * @author Jodan Bustos
 *
 * La barre de menu.
 */
public class MenuBar extends JMenuBar implements Constantes {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2354129022839256414L;

	/**
	 * Constructeur du menu.
	 * @param controleur le controleur.
	 */
	public MenuBar (Controleur controleur) {

		add(nouveauMenuFichier(controleur));
		add(nouveauMenuEdition(controleur));
	}

	/**
	 * Permet de creer le menu edition.
	 * @param controleur le controleur.
	 * @return le menu edition.
	 */
	private JMenu nouveauMenuEdition(Controleur controleur) {
		JMenu menuEdition = new JMenu(EDITION);

		menuEdition.add(nouveauJMenuItem(VALIDER,controleur));
		
		return menuEdition;
	}

	/**
	 * Permet de creer le menu fichier.
	 * @param controleur le controleur.
	 * @return le menu fichier.
	 */
	private JMenu nouveauMenuFichier(Controleur controleur) {
		JMenu menuFichier = new JMenu(FICHIER);

		menuFichier.add(nouveauJMenuItem(ENREGISTRER,controleur));
		menuFichier.add(nouveauJMenuItem(CHARGER,controleur));
		menuFichier.add(nouveauJMenuItem(QUITTER,controleur));
		
		return menuFichier;
	}

	/**
	 * Permet de creer un JMenuItem.
	 * @param name le nom de l'item.
	 * @param controleur le controleur.
	 * @return l'item cree.
	 */
	private JMenuItem nouveauJMenuItem(String name, Controleur controleur) {
		JMenuItem item = new JMenuItem(name);
		
		item.setActionCommand(name);
		item.addActionListener(controleur);
		
		return item;
	}

}
