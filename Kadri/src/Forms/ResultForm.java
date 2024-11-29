package Forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ResultForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public JLabel lblNewLabel;
	private JScrollPane scrollPane;
	String[][] dataOfCompanies = new String[][] {
		{"ООО Техносерв", "Администратор", "Штат", "Среднее", "Информатика и вычислительная техника", "30000"},
		{"АО Z-Банк", "Администратор", "Штат", "Среднее", "Информатика и вычислительная техника", "45000"},
		{"ИП Сапфир", "Аналитик", "Договор ГПХ", "Высшее", "Экономика и управление", "22000"},
		{"ООО Клондайк", "Бухгалтер", "Штат", "Высшее", "Музыкальное искусство", "90000"},
		{"АО Z-Банк", "Диспетчер", "Штат", "Среднее", "Информатика и вычислительная техника", "65000"},
		{"ПАО СборБанк", "Аналитик", "Договор ГПХ", "Среднее", "Экономика и управление", "55000"}
	};
	public String[] personData = MainForm.Data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultForm frame = new ResultForm();
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
	public ResultForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 672, 21);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 672, 207);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Garamond", Font.PLAIN, 11));
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435 \u043A\u043E\u043C\u043F\u0430\u043D\u0438\u0438", "\u0414\u043E\u043B\u0436\u043D\u043E\u0441\u0442\u044C", "\u0412\u0438\u0434 \u0437\u0430\u043D\u044F\u0442\u043E\u0441\u0442\u0438", "\u0412\u0438\u0434 \u043E\u0431\u0440\u0430\u0437\u043E\u0432\u0430\u043D\u0438\u044F", "\u0421\u043F\u0435\u0446\u0438\u0430\u043B\u044C\u043D\u043E\u0441\u0442\u044C", "\u041E\u043A\u043B\u0430\u0434"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(125);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		table = new JTable(model);
		for (int i = 0; i < dataOfCompanies.length; i++)
		{
			String temp1 = Arrays.toString(personData);
			String temp2 = Arrays.toString(new String[] {dataOfCompanies[i][1], dataOfCompanies[i][2], dataOfCompanies[i][3], dataOfCompanies[i][4]});
			if (temp1.equals(temp2) == true)
			{
				model.addRow(dataOfCompanies[i]);
			}
		}
	}
}
