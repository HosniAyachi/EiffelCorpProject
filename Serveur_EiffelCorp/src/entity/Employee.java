package entity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import shared.IEmploy;

public class Employee extends UnicastRemoteObject implements IEmploy {

	private String firstName,lastName,email,address;
	

	
	private int id,age;


	public Employee() throws RemoteException {
		super();
	}


	public Employee(int id, String firstName, String lastName, String email, String address, int age) throws RemoteException {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.age = age;
		
	}
	
	


	
	
	public int getId() throws RemoteException {
		return id;
	}


	public void setId(int id) throws RemoteException {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) throws RemoteException  {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) throws RemoteException  {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) throws RemoteException  {
		this.email = email;
	}


	public String getAddress()  throws RemoteException  {
		return address;
	}


	public void setAddress(String address) throws RemoteException   {
		this.address = address;
	}


	public int getAge() throws RemoteException  {
		return age;
	}


	public void setAge(int age) throws RemoteException  {
		this.age = age;
	}


	@Override
	public String toString()  {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address="
				+ address + ", age=" + age + "]";
	}
	
	
	
	
	
	
}
