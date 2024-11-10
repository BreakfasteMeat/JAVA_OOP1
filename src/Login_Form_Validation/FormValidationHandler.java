package Login_Form_Validation;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class FormValidationHandler extends JFrame{
	public Hashtable<String, String> accounts;

	public FormValidationHandler() throws HeadlessException{
		accounts = new Hashtable<>();
	}
	public void addAccount(String username, String password){
		try {
			if(username == null || username == ""){
				throw new IllegalArgumentException("Username cannot be empty");
			}
			if(username.contains(" ")){
				throw new IllegalArgumentException("Username cannot have spaces");
			}
		} catch(IllegalArgumentException e){

		}
		accounts.put(username, password);
	}
}
