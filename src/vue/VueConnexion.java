package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.C_Administration;
import controleur.CFAINSTA;
import controleur.Administration;

public class VueConnexion extends JFrame implements ActionListener, KeyListener{

    private JTextField txtEmail = new JTextField();
    private JPasswordField txtMdp = new JPasswordField();
    private JButton btAnnuler = new JButton("Annuler");
    private JButton btSeConnecter = new JButton("Se Connecter");


    private JPanel panelCon = new JPanel();

    public VueConnexion () {
        this.setTitle("Gestion de la scolarité");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color (255, 184, 51 ));  
        this.setBounds(200, 200, 700, 300);
        this.setLayout(null);

        ImageIcon logo = new ImageIcon ("src/images/cfainsta_logo.png");
        JLabel monLogo = new JLabel(logo);
        monLogo.setBounds(10, 10, 340, 340);
        this.add(monLogo);

        //construction du panel connexion
        this.panelCon.setBounds(280, 40, 380, 200);
        this.panelCon.setBackground(new Color (255, 184, 51 ));
        this.panelCon.setLayout(new GridLayout(3, 2));
        this.panelCon.add(new JLabel("Email"));
        this.panelCon.add(this.txtEmail);
        this.panelCon.add(new JLabel("MDP"));
        this.panelCon.add(this.txtMdp);
        this.panelCon.add(this.btAnnuler);
        this.panelCon.add(this.btSeConnecter);
        this.add(this.panelCon);
        
        // rendre les deux boutons ecoutables
        this.btAnnuler.addActionListener(this);
        this.btSeConnecter.addActionListener(this);
        
        //ajout evenements frappe de touche
        this.txtEmail.addKeyListener(this);
        this.txtMdp.addKeyListener(this);

        this.setVisible(true);
    }

    public void traitement() {
        String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
            if(email.equals("") || mdp.equals("")) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir vos identifiants !");
            } else {
                // Vérification dans la BDD : table administration

            Administration unAdministrateur = C_Administration.selectWhereAdministrateur(email, mdp);
            if (unAdministrateur == null) {
                JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants !");
            } else {
                JOptionPane.showMessageDialog(this, "Bienvenue MMe/M. "+unAdministrateur.getNom());
                this.txtEmail.setText("");
                this.txtMdp.setText("");

                // Ouverture de session
                CFAINSTA.gererVueConnexion(false);
                CFAINSTA.gererVueGenerale(true, unAdministrateur);
            }
        }

    }
	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btAnnuler)
		{
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		else if (e.getSource() == this.btSeConnecter)
		{
			this.traitement();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.traitement();
        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
