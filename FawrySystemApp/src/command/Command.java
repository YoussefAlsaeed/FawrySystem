package command;

import java.util.ArrayList;

import composite.*;
import mainPackage.*;
import serviceProviders.*;
import transaction.*;

public abstract class Command {

//	Form form;
	User user;
	IServiceProviders service;
	ArrayList<String> values;
	//public Command(Form)
	//public void execute() {}
	public abstract ITransaction execute();
	public ArrayList<String> getValues() {
		return values;
	}
	public void setValues(ArrayList<String> values) {
		this.values = values;
	}
}
