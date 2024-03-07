package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Bidaiaria;
import domain.Driver;
import domain.User;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LogInGUI extends JFrame{
	private JTextField fieldKontuIzena;
	private JPasswordField fieldPasahitza;
	public LogInGUI() {
		
		this.setSize(495, 290);
		
		getContentPane().setLayout(null);
		
		JLabel labelKontuaIzena = new JLabel("Kontuaren email-a");
		labelKontuaIzena.setBounds(321, 24, 148, 14);
		getContentPane().add(labelKontuaIzena);
		
		JLabel labelPasahitza = new JLabel("Pasahitza");
		labelPasahitza.setBounds(321, 78, 148, 14);
		getContentPane().add(labelPasahitza);
		
		fieldKontuIzena = new JTextField();
		fieldKontuIzena.setBounds(68, 16, 218, 30);
		getContentPane().add(fieldKontuIzena);
		fieldKontuIzena.setColumns(10);
		
		JLabel Errorlbl = new JLabel("");
		Errorlbl.setBounds(115, 140, 199, 14);
		getContentPane().add(Errorlbl);
		

		//BLFacade facadeTest = new BLFacadeImplementation(new DataAccess());
		
		JButton loginBotoia = new JButton("Sartu");
		loginBotoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				String pasahitza = new String(fieldPasahitza.getPassword());
				if(!"".equals(fieldKontuIzena.getText()) && !"".equals(pasahitza)) {
					
					User u = facade.LogIn(fieldKontuIzena.getText(), pasahitza);
					if(u == null) {
						Errorlbl.setText("Ez da erabiltzailerik aurkitu!");
					} else {
						
						if(u instanceof Driver) {
						Errorlbl.setText("Driver-a aurkitu da!");
						}
						if(u instanceof Bidaiaria){
						Errorlbl.setText("Bidaiaria aurkitu da!");
						}
						
						//DiruaSartuAteraGUI d=new DiruaSartuAteraGUI(u);
						//d.setVisible(true);
						//dispose();//LoginGUI itxi
					}
					
				}else {
					Errorlbl.setText("Email-a eta pasahitza bete!");
				}
			}
		});
		loginBotoia.setBounds(139, 165, 164, 51);
		getContentPane().add(loginBotoia);
		
		fieldPasahitza = new JPasswordField();
		fieldPasahitza.setBounds(68, 75, 218, 30);
		getContentPane().add(fieldPasahitza);
		
	}
}
