package mainPackage;


public class User {
String username;
String password;
String email;
public double CreditCard=1000;
public double wallet=300;
public void addToWallet(double amount) {
	wallet+=amount;
	CreditCard-=amount;
}
public User ()
{
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
