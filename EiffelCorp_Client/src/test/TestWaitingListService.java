package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import shared.IWaiting;
import shared.IWaitingManagement;


public class TestWaitingListService {

	public TestWaitingListService() throws RemoteException {}

	public boolean testAddToWaitingList(IWaitingManagement WaitingLists, int car_id,int employee_id) throws RemoteException {
		
		System.out.println("\n*-Start Method testAddToWaitingList-*");
		
		boolean result = WaitingLists.addWaiting(car_id, employee_id);
		
		for(IWaiting w : WaitingLists.getWaitingList())
			System.out.println("\n Waiting id : "+w.getId()+" Car id : "+ w.getCar_id()+" Employee Id : "+w.getEmployee_id()+" available date : "+ w.getDate_available().toString()+" request date : "+ w.getRequest_date().toString());
		
		System.out.println("\n*-End Method testAddToWaitingList-*");
		return result;
	
	}
	
	public boolean testRemoveWaiting(IWaitingManagement WaitingLists, int id) {
		
		System.out.println("\n*-Start Method testRemoveWaiting-*");	
		boolean result = false;
		
	try {
		
		result = WaitingLists.removeWaiting(id);
		
		//Display the returned value 
		for(IWaiting w : WaitingLists.getWaitingList())
			System.out.println("\n Waiting id : "+w.getId()+" Car id : "+ w.getCar_id()+" Employee Id : "+w.getEmployee_id()+" available date : "+ w.getDate_available().toString()+" request date : "+ w.getRequest_date().toString());
		
		
	}
	catch(Exception e) {
		
		System.out.println("An Error has occurend during the test of remove Waiting from waiting list : "+e);
		e.printStackTrace();
	}
		
		System.out.println("\n*-End Method testRemoveWaiting-*");		
		return result;
	
	}
	
	public boolean testSearchWaitingListsByCarId(IWaitingManagement WaitingLists, int car_id) {
		
		System.out.println("\n*-Start Method testSearchWaitingListsByCarId-*");
		boolean result = false;
		
		try {
			
			List<IWaiting> result_WaitingLists = WaitingLists.searchWaitingByCarId(car_id);
			
			//Display the returned values
			for(IWaiting w : result_WaitingLists) {
				System.out.println("\n Waiting id : "+w.getId()+" Car id : "+ w.getCar_id()+" Employee Id : "+w.getEmployee_id()+" available date : "+ w.getDate_available().toString()+" request date : "+ w.getRequest_date().toString());
				
				if(w.getCar_id() == car_id)
					result = true;
			}
			
		
				
			
		}
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the test of search waiting list by car id : "+ e);
			e.printStackTrace();
		}
			
		System.out.println("\n*-End Method testSearchWaitingListsByCarId-*");
			return result;
		
		
	
	}
	
	public boolean testSearchWaitingListByEmployeeId(IWaitingManagement WaitingLists, int employee_id) {
		
		System.out.println("\n*-Start Method testSearchWaitingListByEmployeeId-*");	
		boolean result = false;
		
		try {
			
			List<IWaiting> result_WaitingLists = WaitingLists.searchWaitingByEmployeeId(employee_id);
			
			//Display the returned values 
			for(IWaiting w : result_WaitingLists) {
				System.out.println("\n Waiting id : "+w.getId()+" Car id : "+ w.getCar_id()+" Employee Id : "+w.getEmployee_id()+" available date : "+ w.getDate_available().toString()+" request date : "+ w.getRequest_date().toString());
				
				if(w.getEmployee_id() == employee_id)
					result = true;
			}
			
			
				
			
		}
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the test of search waiting list by Employee Id : "+ e);
			e.printStackTrace();
		}
		
			System.out.println("\n*-End Method testSearchWaitingListByEmployeeId-*");	
			return result;
		
	
	}
	
	public boolean testSearchWaitingListById(IWaitingManagement WaitingLists, int id) {
		
		System.out.println("\n*-Start Method testSearchWaitingListById-*");	
		boolean result = false;
			
			try {
				
				IWaiting result_WaitingList = WaitingLists.searchWaitingById(id);
		
				//Display the returned value 
				System.out.println("\n Waiting id : "+result_WaitingList.getId()+" Car id : "+ result_WaitingList.getCar_id()+" Employee Id : "+result_WaitingList.getEmployee_id()+" available date : "+ result_WaitingList.getDate_available().toString()+" request date : "+ result_WaitingList.getRequest_date().toString());
				
					if(result_WaitingList.getId() == id)
						result = true;
				
				
				
					
				
			}
			catch(Exception e) {
				
				System.out.println("An Error has occurend during the test of search waiting by id : "+ e);
				e.printStackTrace();
			}
				
			System.out.println("\n*-End Method testSearchWaitingListById-*");		
			return result;
			
		
	
	}
	
	public boolean testSetWaiting(IWaitingManagement WaitingLists, int car_id, int changeTo) {

			System.out.println("\n*-Start Method testSetWaiting-*");	
			boolean result = true;
			
			try {
				
				List<IWaiting> result_WaitingLists = WaitingLists.searchWaitingByCarId(car_id);
		
				//Display the returned values
				System.out.println("Before Change  : -------------");
				for(IWaiting w : result_WaitingLists) {
					
				
					System.out.println("\n Waiting id : "+w.getId()+" Car id : "+ w.getCar_id()+" Employee Id : "+w.getEmployee_id()+" available date : "+ w.getDate_available().toString()+" request date : "+ w.getRequest_date().toString());
					
					System.out.println("\n -----------------------------------");
					
					w.setCar_id(changeTo);
					
				}
				
				//Display the returned values
				System.out.println("\nAfter Change  : -------------");
				for(IWaiting w : WaitingLists.getWaitingList()) {
					
					System.out.println("\n Waiting id : "+w.getId()+" Car id : "+ w.getCar_id()+" Employee Id : "+w.getEmployee_id()+" available date : "+ w.getDate_available().toString()+" request date : "+ w.getRequest_date().toString());
					
					System.out.println("\n -----------------------------------");
					
					if(w.getCar_id()==car_id) 
						result = false;
					
					
				}
					
				
					
				
			}
			catch(Exception e) {
				
				System.out.println("An Error has occurend during the test of set waiting list opperation : "+ e);
				e.printStackTrace();
			}
				
			System.out.println("\n*-End Method testSetWaiting-*");		
			return result;
	
	}
	
	
	

	public static void main(String[] args) throws RemoteException, MalformedURLException  {
		// TODO Auto-generated method stub
		try {
			
			/*App. WaitingList - Management Test*/
			
			
			IWaitingManagement WaitingLists = (IWaitingManagement) Naming.lookup("rmi://localhost:1100/CarsManagement");
			
			TestWaitingListService tests = new TestWaitingListService();
			
			
			boolean testAddToWaitingList = false, testSearchWaitingListsByCarId = false ,testSearchWaitingListByEmployeeId = false ,testSearchWaitingListById = false ,testSetWaiting = false  ,testRemoveWaiting = false ;
			
			
			testAddToWaitingList = tests.testAddToWaitingList(WaitingLists, 0, 0) && tests.testAddToWaitingList(WaitingLists,0,1) && tests.testAddToWaitingList(WaitingLists,1,2);
			
			testSearchWaitingListsByCarId = tests.testSearchWaitingListsByCarId(WaitingLists, 1);
			
			testSearchWaitingListByEmployeeId = tests.testSearchWaitingListByEmployeeId(WaitingLists, 0);
			
			testSearchWaitingListById = tests.testSearchWaitingListById(WaitingLists,2);
			
			testSetWaiting = tests.testSetWaiting(WaitingLists,0,5);
			
			testRemoveWaiting = tests.testRemoveWaiting(WaitingLists, 1);
			
			System.out.println("\nResult of Tests of RentService :"
					+"\n testAddToWaitingList : "+ testAddToWaitingList
					+"\n testSearchWaitingListsByCarId : "+ testSearchWaitingListsByCarId
					+"\n testSearchWaitingListByEmployeeId : "+ testSearchWaitingListByEmployeeId
					+"\n testSearchWaitingListById : "+ testSearchWaitingListById
					+"\n testSetWaiting : "+ testSetWaiting
					+"\n testRemoveWaiting : "+ testRemoveWaiting);
			
			//Exception
			 }
		
			 catch (Exception e) {
				 
				 e.printStackTrace();
				 System.out.println("An Error Has Occured while running the client for WaitingListService Test stacktrace : " + e);
			 }
		
			 }

	}



