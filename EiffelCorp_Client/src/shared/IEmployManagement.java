package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;




public interface IEmployManagement extends Remote {

	public boolean addEmployee(String firstName, String lastName, String email, String address, int age) throws RemoteException;
	
	public List<IEmploy> searchEmployeeByFirstName(String firstName) throws RemoteException;
	
	public boolean removeEmployeeById(int id) throws RemoteException;
	
	public List<IEmploy> searchEmployeeById(int id) throws RemoteException;
	
	public boolean removeEmployeeByFirstName(String firstName) throws RemoteException;
}
