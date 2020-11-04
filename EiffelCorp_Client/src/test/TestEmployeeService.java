package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import shared.IEmploy;
import shared.IEmployManagement;

public class TestEmployeeService {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// TODO Auto-generated method stub
		

		try {
			
			/*App. Employee - Management Test*/
			
			
			IEmployManagement emp = (IEmployManagement) Naming.lookup("rmi://localhost:1100/EmployeeManagement");
			 
			boolean result = emp.addEmployee("Skander","Marnissi","skander.marnissi@gmail.com","Monfleury",18);
			
			System.out.println(result);
			 
			List<IEmploy> bb = emp.searchEmployeeByFirstName("Skander");
			
		
			
			System.out.println("Employee is : " + bb.get(0).getFirstName() +" "+bb.get(0).getLastName());
			
			bb.get(0).setFirstName("Amine");
			
			bb = emp.searchEmployeeByFirstName("Amine");
			
			System.out.println("Employee is : " + bb.get(0).getFirstName() +" "+bb.get(0).getLastName());
			
			//Exception
			 }
		
			 catch (Exception e) {
				 
				 e.printStackTrace();
				 System.out.println("An Error Has Occured while running the client of Eiffel Corp stacktrace : " + e);
			 }
		
			 }


	}


