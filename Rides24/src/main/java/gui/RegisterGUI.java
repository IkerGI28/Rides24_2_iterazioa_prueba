package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;

import businessLogic.BLFacade;
import exceptions.UserAlreadyExistsException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class RegisterGUI extends JFrame{
	private JTextField fieldKontua;
	private JPasswordField fieldPasahitza;
	private JTextField fieldKontuIzena;
	private JRadioButton rbotoiaBidaiaria;
	private JRadioButton rbotoiaGidaria;
	
	public RegisterGUI() {
		getContentPane().setLayout(null);
		this.setSize(495, 290);
		JLabel labelKontua = new JLabel("Posta elektronikoa");
		labelKontua.setBounds(24, 24, 150, 14);
		getContentPane().add(labelKontua);
		
		fieldKontua = new JTextField();
		fieldKontua.setBounds(198, 14, 231, 35);
		getContentPane().add(fieldKontua);
		fieldKontua.setColumns(10);
		
		JLabel labelPasahitza = new JLabel("Pasahitza");
		labelPasahitza.setBounds(24, 70, 124, 14);
		getContentPane().add(labelPasahitza);
		
		fieldPasahitza = new JPasswordField();
		fieldPasahitza.setBounds(198, 60, 231, 35);
		getContentPane().add(fieldPasahitza);
		
		fieldKontuIzena = new JTextField();
		fieldKontuIzena.setColumns(10);
		fieldKontuIzena.setBounds(198, 105, 231, 35);
		getContentPane().add(fieldKontuIzena);
				
		
		JLabel labelKontuaIzena = new JLabel("Erabiltzaile izena");
		labelKontuaIzena.setBounds(24, 115, 150, 14);
		getContentPane().add(labelKontuaIzena);
		
		rbotoiaGidaria = new JRadioButton("Gidaria");
		rbotoiaGidaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbotoiaGidaria.isSelected()) {
					rbotoiaBidaiaria.setSelected(false);
				}
			}
		});
		rbotoiaGidaria.setBounds(39, 172, 109, 23);
		getContentPane().add(rbotoiaGidaria);
		
		rbotoiaBidaiaria = new JRadioButton("Bidaiaria");
		rbotoiaBidaiaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbotoiaBidaiaria.isSelected()) {
					rbotoiaGidaria.setSelected(false);
				}
			}
		});
		rbotoiaBidaiaria.setBounds(294, 172, 109, 23);
		getContentPane().add(rbotoiaBidaiaria);
		
		JLabel fieldEmaitza = new JLabel("");
		fieldEmaitza.setBounds(227, 204, 231, 29);
		getContentPane().add(fieldEmaitza);
		
		JButton botoiaRegister = new JButton("Erregistratu");
		botoiaRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				if(rbotoiaBidaiaria.isSelected() || rbotoiaGidaria.isSelected()) {
				if(fieldKontuIzena.getText().length() != 0 && new String(fieldPasahitza.getPassword()).length() != 0 && fieldKontua.getText().length() != 0) {
					
					int erabiltzailea = -1;
					if (rbotoiaBidaiaria.isSelected()) {
						erabiltzailea = 0;
					}
			    	if(rbotoiaGidaria.isSelected()) {
						erabiltzailea = 1;
						
					}
			    	try{
			    		
			    		String pasahitza = new String(fieldPasahitza.getPassword());
			    		boolean b = facade.Register(fieldKontua.getText(), fieldKontuIzena.getText(), pasahitza , erabiltzailea);
						//u.toString();
			    		if(b) {
							botoiaRegister.setText("Erregistratuta!");	
							fieldEmaitza.setText("");
			    		}	
			    	}catch (UserAlreadyExistsException exception){
						botoiaRegister.setText("Dagoeneko existitzen da email hori daukan erabiltzailea!");
			    	}
					}else {
						fieldEmaitza.setText("Bete itzazu hutsune guztiak!");
					}
				}else {
					fieldEmaitza.setText("Adierazi ezazu erabiltzaile mota!");
				}
			}
		});
		botoiaRegister.setBounds(10, 197, 207, 43);
		getContentPane().add(botoiaRegister);
		
		
		
		
	}
}