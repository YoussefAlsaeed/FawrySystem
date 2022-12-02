package command;

import composite.*;
import mainPackage.*;

public abstract class Command {

	Form form;
	User user;
	//public Command(Form)
	public void execute(Form form,User user) {}
}
