package command;

import java.util.ArrayList;

import composite.*;
import mainPackage.*;
import serviceProviders.*;

public abstract class Command {

//	Form form;
	User user;
	IServiceProviders service;
	ArrayList<String> values;
	//public Command(Form)
	//public void execute() {}
	public abstract void execute();
	public ArrayList<String> getValues() {
		return values;
	}
	public void setValues(ArrayList<String> values) {
		this.values = values;
	}
}
