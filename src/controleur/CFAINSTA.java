package controleur;

import vue.VueConnexion;
import vue.VueGenerale;

import java.awt.event.ActionEvent;

public class CFAINSTA {

	private static VueConnexion uneVueConnexion;
	private static VueGenerale uneVueGenerale;
	public static void main(String[] args) {
		uneVueConnexion = new VueConnexion();

	}

	public static void gererVueConnexion (boolean action) {
		CFAINSTA.uneVueConnexion.setVisible(action);
	}

	public static void gererVueGenerale (boolean action, Administration unAdministrateur) {
		uneVueGenerale = new VueGenerale(unAdministrateur);
		CFAINSTA.uneVueGenerale.setVisible(action);
	}

}
