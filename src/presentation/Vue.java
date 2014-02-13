package presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import metier.Personne;
import application.Constantes;
import application.Modele;
import application.ModeleListe;

public class Vue extends JPanel implements Observer, Constantes {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2427560436941754817L;

	/** le controleur. */
	private Controleur controleur;
	
	/** le modele.*/
	private Modele modele;
	
	/** les champs. */
	private Map<String,JTextField> lesChamps = new HashMap<String, JTextField>();
	
	/** le panneau d'affichage. */
	private JList<Personne> pnAffichage ;
	
	/** le modele de la JList. */
	private ListModel<Personne> modeleListe ;
	
	/** les civilites. */
	private Map<String,JRadioButton> lesCivilites = new HashMap<>();
	
	/** les hobies. */
	private Map<String, JCheckBox> lesHobies = new HashMap<>() ;
	
	/**
	 * Constructeur de la vue.
	 * @param modeleListe le modele de liste.
	 * @param modele le modele.
	 * @param controleur le controleur.
	 */
	public Vue (Controleur controleur, Modele modele, ModeleListe modeleListe){
		
		this.modeleListe = modeleListe;
		this.modele = modele;
		this.controleur = controleur;
		
		modele.addObserver(this);
		
		setLayout(new BorderLayout());

		add(panneauPersonne(), BorderLayout.CENTER);
		add(panneauCommandes(), BorderLayout.SOUTH);
		add(PanneauAffichage(), BorderLayout.EAST);
	}
	
	
	
	/**
	 * Permet de creer le panneau de saisie d'une personne.
	 * @return le panneau de saisie d'une personne.
	 */
	private Component panneauPersonne() {
		Box pan = Box.createVerticalBox();

		pan.add(nouveauPanneauRadioBouton(CIVILITE));
		pan.add(nouveauPanneau(NOM));
		pan.add(nouveauPanneau(PRENOM));
		pan.add(nouveauPanneau(AGE));
		pan.add(nouveauHobies());
		
		return pan;
	}

	/**
	 * Permet de creer le panneau des hobies.
	 * @return le panneau des hobies.
	 */
	private Component nouveauHobies() {
		JPanel pan = new JPanel() ;
		JScrollPane scrolling = new JScrollPane(pan) ;
		
		pan.add(nouvelleHobie(BASKETBALL));
		pan.add(nouvelleHobie(FOOTBALL));
		pan.add(nouvelleHobie(SOCCER));
		pan.add(nouvelleHobie(RUGBY));
		pan.add(nouvelleHobie(LECTURE));
		pan.add(nouvelleHobie(MUSIQUE));		
		
		return scrolling;
	}

	/**
	 * Permet de creer une hobie.
	 * @param name le nom de la hobie.
	 * @return une nouvelle hobie.
	 */
	private Component nouvelleHobie(String name) {
		JCheckBox hob = new JCheckBox(name) ;
		
		hob.setName(name);
		hob.setActionCommand(HOBIE);
		hob.addItemListener(controleur);
		lesHobies.put(name,hob);
		
		return lesHobies.get(name);
	}



	/**
	 * Permet de creer un panneau pour les radios boutons.
	 * @param name le nom du panneau.
	 * @return le panneau pour les radios boutons.
	 */
	private Component nouveauPanneauRadioBouton(String name) {
		JPanel pan = new JPanel();
		
		ButtonGroup groupe = new ButtonGroup();

		pan.add(nouveauRadioBouton(M, groupe, true));
		pan.add(nouveauRadioBouton(MME, groupe, false));
		pan.add(nouveauRadioBouton(MLLE, groupe, false));
		
		return pan;
	}


	/**
	 * Permet de creer un nouveau radio bouton.
	 * @param name le nom du radio bouton.
	 * @param groupe le groupe du radio bouton.
	 * @param active indique si le radio bouton est active ou non.
	 * @return le radio bouton cree.
	 */
	private Component nouveauRadioBouton(String name, ButtonGroup groupe, boolean active) {
		JRadioButton rBp = new JRadioButton(name);
						
		rBp.setName(name);
		rBp.setSelected(active);
		rBp.setActionCommand(CIVILITE);
		rBp.addActionListener(controleur);
		groupe.add(rBp);
		
		lesCivilites.put(name, rBp);
		
		return lesCivilites.get(name);
	}



	/**
	 * Permet de creer un panneau.
	 * @param name le nom du panneau.
	 * @return le panneau.
	 */
	private Component nouveauPanneau(String name) {
		JPanel pan = new JPanel();
		pan.setLayout(new FlowLayout());
		
		pan.add(nouveauLabel(name));
		pan.add(nouveauChamp(name));
		
		return pan;
	}


	/**
	 * Permet de creer un nouveau label.
	 * @param name le nom du label.
	 * @return le nouveau label.
	 */
	private Component nouveauLabel(String name) {
		JLabel label = new JLabel(name);
		return label;
	}


	/**
	 * Permet de creer un nouveau champ.
	 * @param name le nom du champ.
	 * @return le nouveau champ.
	 */
	private Component nouveauChamp(String name) {
		JTextField champ = new JTextField();
		champ.setPreferredSize(new Dimension(100,25));
		
		champ.setName(name);
		
		champ.addActionListener(controleur);
		champ.addFocusListener(controleur);
		
		lesChamps.put(name, champ);
		
		return lesChamps.get(name);
	}


	/**
	 * Permet de creer le panneau des commandes.
	 * @return
	 */
	private Component panneauCommandes() {
		JPanel pan = new JPanel();
		pan.setLayout(new FlowLayout());
		
		pan.add(nouveauBouton(VALIDER));
		pan.add(nouveauBouton(NETOYER));
		//pan.add(nouveauBouton(QUITTER));
		
		return pan;
	}



	/**
	 * Permet de creer un nouveau bouton.
	 * @param name le nom du bouton.
	 * @return le nouveau bouton.
	 */
	private Component nouveauBouton(String name) {
		JButton bouton = new JButton(name);
		
		bouton.setActionCommand(name);
		bouton.addActionListener(controleur);
		
		return bouton;
	}


	/**
	 * Permet de creer le panneau d'affichage;
	 * @return le panneau d'affichage cree.
	 */
	private Component PanneauAffichage() {
		pnAffichage = new JList<Personne>();
		
		JScrollPane scrolling = new JScrollPane(pnAffichage);
		
		pnAffichage.setModel(modeleListe);
		pnAffichage.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pnAffichage.addListSelectionListener(controleur);
		
		return scrolling;
	}




	@Override
	public void update(Observable source, Object info) {
		
		if (source instanceof Modele){
						
			if (info.toString().equals(CIVILITE)){
				lesCivilites.get(modele.getTextOfChamp(CIVILITE)).setSelected(true);
			}
			
			else if (info.toString().equals(NOM)){
				lesChamps.get(NOM).setText(modele.getTextOfChamp(NOM));
			}
			else if(info.toString().equals(PRENOM)){
				lesChamps.get(PRENOM).setText(modele.getTextOfChamp(PRENOM));
			}
			else if (info.toString().equals(AGE)){
				lesChamps.get(AGE).setText(modele.getTextOfChamp(AGE));
			}
			else if (info.toString().equals(FOCUS)) {
				lesChamps.get(modele.getFocus()).requestFocusInWindow();
			}
			else if (info.toString().equals(HOBIE))
			{
				for (String hob : lesHobies.keySet())
				{
					if (modele.getHobie(hob))
						lesHobies.get(hob).setSelected(true);
					else
						lesHobies.get(hob).setSelected(false);
				}
			}
			
		}

	}

}
