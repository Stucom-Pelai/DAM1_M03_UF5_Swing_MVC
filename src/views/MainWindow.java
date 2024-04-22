package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.SpringLayout;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class MainWindow implements ActionListener, KeyListener{

	private JFrame frame;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 100, 745, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		btnNewButton = new JButton("Añadir persona");
		btnNewButton.setBounds(295, 109, 127, 23);
		btnNewButton.addActionListener(this);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Menu principal mantenimiento personas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(114, 38, 545, 60);
		frame.getContentPane().add(lblNewLabel);


	}
	
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == btnNewButton) {    		
    		int optionSelected = JOptionPane.showConfirmDialog(frame, "¿Está seguro de pulsar el botón de insertar?");
//    		//pane.setVisible(true);
    		if(optionSelected == 0) {
    			CreateView createView = new CreateView(frame);
    			createView.initializeComponents();
    			createView.visualize();
    		}    		
    	}
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
