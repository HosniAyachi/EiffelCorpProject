package main;

import java.net.MalformedURLException;
import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import service.EmployeeService;

import shared.IEmployManagement;

public class ServerEiffelCorp {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// TODO Auto-generated method stub

		try {
			
			LocateRegistry.createRegistry(1100);
			
			IEmployManagement emp = new EmployeeService();
			
			
			Naming.rebind("rmi://localhost:1100/EmployeeManagement",emp);
			
			}
		
		catch (Exception e) {
			
			 System.out.println("An Error Has Occured while running the server  stacktrace : " + e.getMessage());
			 
			 }
	
	}

}
