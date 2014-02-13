/**
 * @author jobustos
 */
package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import application.Constantes;
import application.Modele;

/**
 * @author jobustos
 *
 */
public class Controleur implements ActionListener, FocusListener, ListSelectionListener, ItemListener, Constantes{

	/** le modele. */
	private Modele modele;

	/**
	 * Constructeur du controleur.
	 * @param modele le modele.
	 */
	public Controleur(Modele modele) {
		
		this.modele = modele ;
		
	}

	@Override
	public void focusGained(FocusEvent fg) {
		if (fg.getSource() instanceof JTextField){
			JTextField champ = (JTextField) fg.getSource();
			modele.placerFocus(champ.getName());
		}
		
	}

	@Override
	public void focusLost(FocusEvent fe) {
		
		if (fe.getSource() instanceof JTextField){
			JTextField champ = (JTextField) fe.getSource();
			modele.modifierChamp(champ.getName(),champ.getText());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() instanceof JButton){
			JButton bouton = (JButton) ae.getSource();
			
			if (bouton.getActionCommand().equals(VALIDER)){
				modele.ajouterPersonne();
			}
			
			if (bouton.getActionCommand().equals(NETOYER)){
				modele.netoyerChamps();
			}
		}
		
		if (ae.getSource() instanceof JRadioButton){
			JRadioButton radioBouton = (JRadioButton) ae.getSource();
			
			if (radioBouton.getActionCommand().equals(CIVILITE))
				modele.modifierChamp(CIVILITE, radioBouton.getName());
		}
		
		if (ae.getSource() instanceof JTextField)
			modele.focusSuivant();
		
		if (ae.getSource() instanceof JMenuItem)
		{
			JMenuItem item = (JMenuItem)ae.getSource() ;
			
			if (item.getText().equals(VALIDER))
				modele.ajouterPersonne();

			if (item.getText().equals(ENREGISTRER))
				modele.sauvegarder () ;
			
			if (item.getText().equals(CHARGER)){
				modele.charger() ;
			}
			
			if (item.getText().equals(QUITTER)){
				modele.quitter();
			}
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if (!e.getValueIsAdjusting())
		{ 
			// recuperation de la position de l'item selectionne dans la liste
			int index = ((JList<?>)e.getSource()).getSelectedIndex() ;
			if (index>=0)
				modele.setPersonne(index); 
		}
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {

		if (ie.getSource() instanceof JCheckBox)
		{
			JCheckBox hob = (JCheckBox) ie.getSource() ;
			
			if (hob.getActionCommand().equals(HOBIE))
			{
				boolean selected = (ie.getStateChange() == ItemEvent.SELECTED) ;
				modele.setHobie(hob.getName(), selected) ; 
			}
		}
		
	}
	
	
	

}
