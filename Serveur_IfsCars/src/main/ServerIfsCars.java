package main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import service.CarService;
import service.FeedBackService;
import service.RentalService;
import service.WaitingListService;
import shared.ICarsManagement;
import shared.IFeedBackManagement;
import shared.IRentalsManagement;
import shared.IWaitingManagement;

public class ServerIfsCars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
				
				LocateRegistry.createRegistry(1100);
				
				ICarsManagement cars = new CarService();
				
				IRentalsManagement rentals = new RentalService();
				
				IWaitingManagement waitings = new WaitingListService();
				
				IFeedBackManagement feedBacks = new FeedBackService();
				
				
				
				
				Naming.rebind("rmi://localhost:1100/CarsManagement",cars);
				Naming.rebind("rmi://localhost:1100/RentalsManagement",rentals);
				Naming.rebind("rmi://localhost:1100/WaitingManagement",waitings);
				Naming.rebind("rmi://localhost:1100/FeedBackManagement",feedBacks);
				
				
				}
			
			catch (Exception e) {
				
				 System.out.println("An Error Has Occured while running the server  stacktrace : " + e.getMessage());
				 
				 }
		
		}

	}


