package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.PersonController;
import model.Person;
import utils.Utils;

import java.awt.Font;

public class CreateView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	PersonController personaController;
	JDialog insertWindow;
	JFrame parentFrame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton insertButton;
	private JButton cancelButton;
	private JTextField TextFieldName;
	private JTextField TextFieldSurname;

	public CreateView(JFrame frame) {
		insertWindow = new JDialog(frame);
		personaController = new PersonController();
		parentFrame = frame;
		insertWindow.setBounds(frame.getBounds());
		insertWindow.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(66, 82, 64, 17);
		insertWindow.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(66, 153, 64, 17);
		insertWindow.getContentPane().add(lblNewLabel_1);

		insertButton = new JButton("Insertar");
		insertButton.setBounds(229, 205, 89, 23);
		insertButton.addActionListener(this);
		insertWindow.getContentPane().add(insertButton);

		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(70, 205, 89, 23);
		cancelButton.addActionListener(this);
		insertWindow.getContentPane().add(cancelButton);

		TextFieldName = new JTextField();
		TextFieldName.setBounds(140, 79, 206, 20);
		insertWindow.getContentPane().add(TextFieldName);
		TextFieldName.setColumns(10);

		TextFieldSurname = new JTextField();
		TextFieldSurname.setColumns(10);
		TextFieldSurname.setBounds(140, 150, 206, 20);
		insertWindow.getContentPane().add(TextFieldSurname);

		lblNewLabel_2 = new JLabel("Inserción de una persona");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_2.setBounds(94, 22, 252, 30);
		insertWindow.getContentPane().add(lblNewLabel_2);
	}

	public void initializeComponents() {

	}

	public void visualize() {
		parentFrame.setVisible(false);
		insertWindow.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertButton) {
			// clicked on insert button
			String nombre = TextFieldName.getText();
			String apellidos = TextFieldSurname.getText();

			if (nombre == "" || apellidos == "" || nombre.length() < 2 || apellidos.length() < 2
					|| Utils.isNumeric(apellidos) || Utils.isNumeric(nombre)) {
				JOptionPane.showMessageDialog(insertWindow,
						"ERROR: HA INTRODUCIDO MAL LOS DATOS DE LA PERSONA, POR FAVOR VUELVA A INTRODUCIRLOS",
						"Error de Inserción", JOptionPane.ERROR_MESSAGE);

			} else {
				Person p = new Person(nombre, apellidos);
				this.personaController.addPerson(p);
				TextFieldName.setEditable(false);
				TextFieldSurname.setEditable(false);
				JOptionPane.showMessageDialog(null, "Persona añadida ", "Information", JOptionPane.INFORMATION_MESSAGE);
				// release current screen
				insertWindow.setVisible(false);
				parentFrame.setVisible(true);

			}

		}
		if (e.getSource() == cancelButton) {
			// clicked on cancel button
			insertWindow.setVisible(false);
			parentFrame.setVisible(true);
		}
	}
}
