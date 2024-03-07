package gui;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextField;

import businessLogic.BLFacade;
import domain.*;
import exceptions.NotEnoughMoneyException;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextPane;

public class DiruaSartuAteraGUI extends JFrame{
	private JTextField textZenbatDiru;
	public DiruaSartuAteraGUI(User u) {
		
    	BLFacade facade = MainGUI.getBusinessLogic();

		getContentPane().setLayout(null);
		
		this.setSize(495, 290);
		
		JRadioButton rbotoiaDiruaSartu = new JRadioButton("Dirua sartu");
		rbotoiaDiruaSartu.setBounds(30, 34, 109, 23);
		getContentPane().add(rbotoiaDiruaSartu);
		
		JRadioButton rbotoiaDiruaAtera = new JRadioButton("Dirua atera");
		rbotoiaDiruaAtera.setBounds(153, 34, 109, 23);
		getContentPane().add(rbotoiaDiruaAtera);
		
		
		rbotoiaDiruaSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbotoiaDiruaSartu.isSelected()) {
					rbotoiaDiruaAtera.setSelected(false);
				}
			}
		});
		
		rbotoiaDiruaAtera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbotoiaDiruaAtera.isSelected()) {
					rbotoiaDiruaSartu.setSelected(false);
				}
			}
		});
		
		JButton diruaSartuAteraBotoia = new JButton("Transferentzia egin");
		diruaSartuAteraBotoia.setBounds(49, 165, 177, 58);
		getContentPane().add(diruaSartuAteraBotoia);
		
		textZenbatDiru = new JTextField();
		textZenbatDiru.setBounds(59, 89, 134, 39);
		getContentPane().add(textZenbatDiru);
		textZenbatDiru.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Diru kopurua aukeratu");
		lblNewLabel.setBounds(40, 64, 267, 14);
		getContentPane().add(lblNewLabel);
		
		JButton DiruaErak = new JButton("Nire dirua erakutsi");	
		
		DiruaErak.setBounds(302, 60, 149, 23);
		getContentPane().add(DiruaErak);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(302, 43, 167, 14);
		getContentPane().add(lblNewLabel_1);
		
		DiruaErak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				lblNewLabel_1.setText("Kontuan duzun dirua = " + facade.diruKopLortu(u.getEmail()));
			}
		});
		
		diruaSartuAteraBotoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
			try {
				int dirua = Integer.parseInt(textZenbatDiru.getText());
				if(dirua>0) {
					if(rbotoiaDiruaSartu.isSelected() || rbotoiaDiruaAtera.isSelected()) {
						
						
						if(rbotoiaDiruaSartu.isSelected()){
							int diruBerria = facade.diruaSartu(u.getEmail(),Integer.parseInt(textZenbatDiru.getText()));
							lblNewLabel.setText("Diru kopurua aukeratu");
							lblNewLabel_1.setText("Kontuan duzun dirua = " + diruBerria);							
						}
						
						
						if(rbotoiaDiruaAtera.isSelected()){
							try {
								int diruBerria = facade.diruaAtera(u.getEmail(),Integer.parseInt(textZenbatDiru.getText()));
								lblNewLabel.setText("Diru kopurua aukeratu");
								lblNewLabel_1.setText("Kontuan duzun dirua = " + diruBerria);	
							}catch(NotEnoughMoneyException er) {
								lblNewLabel.setText("Ez daukazu transferentzia egiteko dirua!");
							}
						}	
						
					}else {
						lblNewLabel.setText("Transferentzia mota aukeratu");
					}
				}else {
					lblNewLabel.setText("0 baino handiagoa den zenbakia idatzi!");
				}
				
			}catch(NumberFormatException err) {
					lblNewLabel.setText("Diru kopurua ondo jarri mesedez!");
			}
				
			}
		});


		
	}
}
