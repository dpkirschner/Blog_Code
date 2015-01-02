package com.kirscd.demo.passby;

public class ValetTicket {
	public int id;
	
	public ValetTicket(int id) {
		this.id = id;
	}
	
	public static void swap(ValetTicket ticket){
	    System.out.println("During method call...");
	    ticket.setId(10);
	    System.out.println(String.format("Value of given valetTicket is now: %d", ticket.getId()));
    }
	
	public static void confusing(ValetTicket ticket) {
	    System.out.println("During method call...");
	    ticket = new ValetTicket(10);
		System.out.println(String.format("Value of the new valetTicket is now: %d", ticket.getId()));
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
