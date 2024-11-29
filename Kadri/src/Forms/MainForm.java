package Forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	public static String Busy;
	public static String Education;
	public static String[] Data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainForm() {
		
		setTitle("Заполнение анкеты");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Фамилия");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 253, 21);
		contentPane.add(lblNewLabel);
		
		textField_0 = new JTextField();
		textField_0.setBounds(332, 11, 253, 21);
		contentPane.add(textField_0);
		textField_0.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Должность");
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 107, 253, 21);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_0 = new JComboBox();
		comboBox_0.setFont(new Font("Garamond", Font.PLAIN, 15));
		comboBox_0.setModel(new DefaultComboBoxModel(new String[] {"Администратор", "Аналитик", "Бухгалтер", "Диспетчер"}));
		comboBox_0.setBounds(332, 107, 253, 21);
		contentPane.add(comboBox_0);
		
		JLabel lblNewLabel_1_1 = new JLabel("Вид занятости");
		lblNewLabel_1_1.setFont(new Font("Impact", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 139, 253, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JRadioButton radiobutton1 = new JRadioButton("Штат");
		radiobutton1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Busy = "Штат";
			}
		});
		radiobutton1.setFont(new Font("Impact", Font.PLAIN, 16));
		radiobutton1.setBounds(332, 139, 109, 20);
		contentPane.add(radiobutton1);
		
		JRadioButton radiobutton2 = new JRadioButton("Договор ГПХ");
		radiobutton2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Busy = "Договор ГПХ";
			}
		});
		radiobutton2.setFont(new Font("Impact", Font.PLAIN, 16));
		radiobutton2.setBounds(476, 138, 109, 21);
		contentPane.add(radiobutton2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Вид образования");
		lblNewLabel_1_1_1.setFont(new Font("Impact", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 172, 253, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		JRadioButton radiobutton3 = new JRadioButton("Среднее");
		radiobutton3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Education = "Среднее";
			}
		});
		radiobutton3.setFont(new Font("Impact", Font.PLAIN, 16));
		radiobutton3.setBounds(332, 172, 109, 20);
		contentPane.add(radiobutton3);
		
		JRadioButton radiobutton4 = new JRadioButton("Высшее");
		radiobutton4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Education = "Высшее";
			}
		});
		radiobutton4.setFont(new Font("Impact", Font.PLAIN, 16));
		radiobutton4.setBounds(476, 171, 109, 21);
		contentPane.add(radiobutton4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Специалист по диплому");
		lblNewLabel_1_2.setFont(new Font("Impact", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 204, 253, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Garamond", Font.PLAIN, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Информатика и вычислительная техника", "Экономика и управление", "Музыкальное искусство", "Архитектура"}));
		comboBox_1.setBounds(332, 204, 253, 21);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Вывести подходящие анкеты");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_0.getText().length() == 0 || textField_1.getText().length() == 0 || textField_2.getText().length() == 0 || (radiobutton1.isSelected() || radiobutton2.isSelected()) == false || (radiobutton3.isSelected() || radiobutton4.isSelected()) == false)
				{
					JOptionPane.showMessageDialog(null, "Введены не все данные!");
					return;
				}
				
				Data = new String[]{String.valueOf(comboBox_0.getSelectedItem()), Busy, Education, String.valueOf(comboBox_1.getSelectedItem())};
				ResultForm rslt = new ResultForm();
				rslt.lblNewLabel.setText("Таблица анкет, подходящие для Вас, " + textField_1.getText() + " " + textField_2.getText());
				rslt.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Impact", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 236, 575, 23);
		contentPane.add(btnNewButton);
		
		ButtonGroup btng1 = new ButtonGroup();
		btng1.add(radiobutton1);
		btng1.add(radiobutton2);
		
		ButtonGroup btng2 = new ButtonGroup();
		btng2.add(radiobutton3);
		btng2.add(radiobutton4);
		
		JLabel lblNewLabel_2 = new JLabel("Имя");
		lblNewLabel_2.setFont(new Font("Impact", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 43, 253, 21);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(332, 43, 253, 21);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Отчество");
		lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 75, 253, 21);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(332, 75, 253, 21);
		contentPane.add(textField_2);
	}
}
