package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


import entity.FeedBack;

import shared.IFeedBack;
import shared.IFeedBackManagement;

public class FeedBackService extends UnicastRemoteObject implements IFeedBackManagement {
	
	List<IFeedBack> feedBacks;

	public FeedBackService() throws RemoteException {
		super();
		this.feedBacks = new ArrayList<IFeedBack>();
	}
	
	
	public boolean addFeedBack(int car_id, int employee_id, int rating, String description) throws RemoteException {
		
		try {
			
			if(this.feedBacks.isEmpty()) {
				this.feedBacks.add(new FeedBack(0,car_id,employee_id,rating,description));
				return true;
				}
			
			else {
				this.feedBacks.add(new FeedBack(this.feedBacks.get(this.feedBacks.size()-1).getId()+1,car_id,employee_id,rating,description));
				return true;
				}
				
			}
	
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the addition of feedback process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return false;
		
	}
	
	
	public List<IFeedBack> searchFeedBackByCarId(int car_id) throws RemoteException {
		
		try {
			
			List result = new ArrayList<FeedBack>(); 
			
			for(IFeedBack f :this.feedBacks) {
				
				if(f.getCar_id()==car_id) {
					 
					result.add(f);
					
				}
			
			}
			
			return 	result;
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the research of feedback by car id process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return null;
		
	}
	
	public List<IFeedBack> searchFeedBackByEmployeeId(int employee_id) throws RemoteException{
		
		try {
			
			List result = new ArrayList<FeedBack>(); 
			
			for(IFeedBack f :this.feedBacks) {
				
				if(f.getEmployee_id()==employee_id) {
					 
					result.add(f);
					
				}
			
			}
			
			return 	result;
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the research of feedback by employee id process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return null;
		
	}
	
	public IFeedBack searchFeedBackById(int id) throws RemoteException {
		
		try {
				
			for(IFeedBack f :this.feedBacks) {
				
				if(f.getId()==id) {
					 
					return 	f;
					
				}
			
			}
			
			
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the research of feedback by id process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return null;
		
	}
	
	
	public boolean removeFeedBack(int id) throws RemoteException {
	
		try {
			
			for(IFeedBack f :this.feedBacks) {
				
				if(f.getId()==id) {
					 
					this.feedBacks.remove(f);
					return true;
				}
			
			}
			
				
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the deletion of feedBack process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return false;
		
	}
	

	public List<IFeedBack> getFeedBacks() throws RemoteException {
		return feedBacks;
	}

	public void setFeedBacks(List<IFeedBack> feedBacks) throws RemoteException {
		this.feedBacks = feedBacks;
	}
	
	
	

}
