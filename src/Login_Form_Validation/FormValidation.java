package Login_Form_Validation;

import javax.swing.*;

public class FormValidation extends JFrame{
	private JPanel contentPane;
	private JTextField textField1;
	private JPasswordField passwordField1;
	private JButton loginButton;
	private JButton signUpButton;

	public FormValidation(){
		super("App Form");
	}

	@Override
	public JPanel getContentPane(){
		return contentPane;
	}
}
