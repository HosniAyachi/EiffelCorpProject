package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entity.WaitingList;

import shared.IWaiting;
import shared.IWaitingManagement;

public class WaitingListService extends UnicastRemoteObject implements IWaitingManagement {
	
	List<IWaiting> waitingList;

	public WaitingListService() throws RemoteException {
		super();
		this.waitingList = new ArrayList<IWaiting>();
	}
	
	public boolean addWaiting(int car_id, int employee_id) throws RemoteException {
		
		try {
			
			if(this.waitingList.isEmpty()) {
				this.waitingList.add(new WaitingList(0,car_id,employee_id));
				
				
				//set the available date field !!
				
				return true;
				}
			
			else {
				this.waitingList.add(new WaitingList(this.waitingList.get(this.waitingList.size()-1).getId()+1,car_id,employee_id));
				return true;
				}
				
			}
	
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the addition of waiting process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return false;
		
	}
	
	
	public List<IWaiting> searchWaitingByCarId(int car_id) throws RemoteException {
		
		try {
			
			List result = new ArrayList<WaitingList>(); 
			
			for(IWaiting w :this.waitingList) {
				
				if(w.getCar_id()==car_id) {
					 
					result.add(w);
					
				}
			
			}
			
			return 	result;
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the research of waiting by car id process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return null;
		
	}
	
	public List<IWaiting> searchWaitingByEmployeeId(int employee_id) throws RemoteException{
		
		try {
			
			List result = new ArrayList<WaitingList>(); 
			
			for(IWaiting w :this.waitingList) {
				
				if(w.getEmployee_id()==employee_id) {
					 
					result.add(w);
					
				}
			
			}
			
			return 	result;
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the research of waiting by employee id process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return null;
		
	}
	
	public IWaiting searchWaitingById(int id) throws RemoteException {
		
		try {
			
			for(IWaiting w :this.waitingList) {
				
				if(w.getId()==id) {
					 
					return 	(IWaiting) w;
					
				}
			
			}
			
			
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the research of waiting by id process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return null;
		
	}
	

	
	
	public boolean removeWaiting(int id) throws RemoteException {
	
		try {
			
			for(IWaiting w :this.waitingList) {
				
				if(w.getId()==id) {
					 
					this.waitingList.remove(w);
					return true;
				}
			
			}
			
				
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the deletion of waiting process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return false;
		
	}
	
	
	public Set<Integer> detectAvailableCars( List<IWaiting> waitingList) {
		
		try {
			
			Set<Integer> result = new HashSet<Integer>(); 
			
			for(IWaiting w : waitingList) {
				
				if(w.getDate_available().after(new Date())) {
					result.add(w.getCar_id());
				}
				
			}
			
			return result;
			
		}
		
		catch(Exception e) {
			System.out.println("An Error has occurend during the detect availablity of cars in the wating list process stacktrace : "+ e);
			e.printStackTrace();
		}
			
		return null ;
		
		
	}

	@SuppressWarnings("unchecked")
	public void notifyEmployee(List<IWaiting> waitingList){
	
		try {
			
			List result = new ArrayList<WaitingList>(); 
			
			Set<Integer> id_cars = detectAvailableCars(waitingList);
			
			for(int i : id_cars) {
				
					for(IWaiting w : waitingList) {
					
						if(w.getCar_id()==i) {
							result.add(w.getCar_id());
					}
						
						Collections.sort(result, new Comparator<WaitingList>() {
							  						public int compare(WaitingList w1, WaitingList w2)  {
													
								
							  								try {
							  										return ((Date) w1.getRequest_date()).compareTo( ((Date) w2.getRequest_date()))  ;
									
							  									} catch (RemoteException e) {
							  										// TODO Auto-generated catch block
							  										e.printStackTrace();
							  									}
							  								return 0;
							      
							  							}
													});
					
					//display the sorted list
						displayWatings(result);
						
					//notify The first employee in the list
						
						System.out.println(" Employee  : " +w.getEmployee_id() +" will be notified for car : "+w.getCar_id());
						
						}
			}
				
		
		}
		
		catch(Exception e) {
			System.out.println("An Error has occurend during the sort waiting list by date  process stacktrace : "+ e);
			e.printStackTrace();
		}

	}
		
	public void displayWatings(List<IWaiting> waitings) {
		
		try {
			for(IWaiting w : waitings ) {
				
				System.out.println("Waiting : "+ w.toString());
				
			}
			
		}
		catch(Exception e) {
			System.out.println("An Error has occurend during the display of waiting list process stacktrace : "+ e);
			e.printStackTrace();
		}
		
		
		
	}
	
	public List<IWaiting> getWaitingList() throws RemoteException {
		return waitingList;
	}

	public void setWaitingList(List<IWaiting> waitingList) throws RemoteException {
		this.waitingList = waitingList;

		}
	
	

	
	
	
	

}
