package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.Administration;
import controleur.CFAINSTA;

public class VueGenerale extends JFrame implements ActionListener {

	private JPanel panelMenu = new JPanel();
    private JButton btClasses = new JButton("Gestion Classes");
    private JButton btProfesseurs = new JButton("Gestion Professeurs");
    private JButton btEtudiants = new JButton("Gestion Etudiants");
    private JButton btAdministrations = new JButton("Gestions Administrations");
    private JButton btProfil = new JButton("Mon Profil");
    private JButton btQuitter = new JButton("Quitter");

    private static PanelProfil unPanelProfil = new PanelProfil();
    private static PanelClasses unPanelClasse = new PanelClasses();
    private static PanelProfesseurs unPanelProfesseur = new PanelProfesseurs();
    private static PanelEtudiants unPanelEtudiant = new PanelEtudiants();
    private static PanelAdministrations unPanelAdministration = new PanelAdministrations();

    public VueGenerale (Administration unAdministrateur) {

        // Instanciation du panel Profil

        this.setTitle("Gestion de la scolarité");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color (255, 184, 51 ));  
        this.setBounds(100, 100, 1200, 700);
        this.setLayout(null);

        // Construction du panel Menu
        this.panelMenu.setBounds(100, 20, 900, 40);
        this.panelMenu.setBackground(new Color (255, 184, 51 ));
        this.panelMenu.setLayout(new GridLayout(1, 7));
        this.panelMenu.add(this.btProfil);
        this.panelMenu.add(this.btClasses);
        this.panelMenu.add(this.btProfesseurs);
        this.panelMenu.add(this.btEtudiants);
        this.panelMenu.add(this.btAdministrations);
        this.panelMenu.add(this.btQuitter);
        this.add(this.panelMenu);

        //rendre les boutons ecoutables
        this.btQuitter.addActionListener(this);
        this.btClasses.addActionListener(this);
        this.btProfesseurs.addActionListener(this);
        this.btEtudiants.addActionListener(this);
        this.btAdministrations.addActionListener(this);
        this.btProfil.addActionListener(this);

        //rendre les boutons ecoutables
        this.btQuitter.addActionListener(this);
        this.btClasses.addActionListener(this);
        this.btProfesseurs.addActionListener(this);
        this.btEtudiants.addActionListener(this);
        this.btAdministrations.addActionListener(this);
        this.btProfil.addActionListener(this);

        //insertion des panels dans la fenêtre
        this.add(unPanelProfil);
        this.add(unPanelClasse);
        this.add(unPanelProfesseur);
        this.add(unPanelEtudiant);
        this.add(unPanelAdministration);


        this.setVisible(false);
    }

    public static void activerPanel (int choix)
    {
        unPanelProfil.setVisible(false);
        unPanelClasse.setVisible(false);
        unPanelProfesseur.setVisible(false);
        unPanelEtudiant.setVisible(false);
        unPanelAdministration.setVisible(false);
        switch (choix)
        {
            case 1 : unPanelProfil.setVisible(true); break;
            case 2 : unPanelClasse.setVisible(true); break;
            case 3 : unPanelProfesseur.setVisible(true); break;
            case 4 : unPanelEtudiant.setVisible(true); break;
            case 5 : unPanelAdministration.setVisible(true); break;
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btQuitter) {
            int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application ?",
                        "Quitter l'application ?", JOptionPane.YES_NO_OPTION);

            if (retour == 0) {
                        this.dispose();
                        CFAINSTA.gererVueConnexion(true);
            }
        }
        else if (e.getSource() == this.btProfil) {
            activerPanel(1);

        }
        else if (e.getSource() == this.btClasses) {
            activerPanel(2);

        }
        else if (e.getSource() == this.btProfesseurs) {
            activerPanel(3);

        }
        else if (e.getSource() == this.btEtudiants) {
            activerPanel(4);

        }
        else if (e.getSource() == this.btAdministrations) {
            activerPanel(5);

        }
		
	}
	
}