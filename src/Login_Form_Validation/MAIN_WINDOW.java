package Login_Form_Validation;

import javax.swing.*;
import java.awt.*;

public class MAIN_WINDOW extends JFrame{
	private JPanel contentPane;
	private JPanel loginPanel;
	private JPanel signUpPanel;

	@Override
	public JPanel getContentPane(){
		return contentPane;
	}

	public MAIN_WINDOW() throws HeadlessException{
		loginPanel = new FormValidation().getContentPane();
		signUpPanel  = new SignUpWindow().getContentPane();
		contentPane.add(loginPanel);
	}
	public void showSignUpPanel(){
		((CardLayout) contentPane.getLayout()).show(signUpPanel, "Sign Up");
	}
	public void showLoginPanel(){
		((CardLayout) contentPane.getLayout()).show(loginPanel, "Log In");
	}
}
