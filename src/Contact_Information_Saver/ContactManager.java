package Contact_Information_Saver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ContactManager extends JFrame{
	private JPanel contentPanel;
	private JTable JtblContacts;
	public ContactManager(){
		super("Contacts Manager");
		initWindow();
		initTable();




	}
	private void initTable(){
		Object[] columns = new Object[]{"Name", "Phone Number"};
		Object[][] data_header = new Object[][]{ columns };
		TableModel model = new DefaultTableModel(data_header,columns){
			@Override
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		JtblContacts.setModel(model);
	}
	private void initWindow(){
		this.setContentPane(contentPanel);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(300,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public JPanel getContentPanel(){

		return contentPanel;
	}
}
