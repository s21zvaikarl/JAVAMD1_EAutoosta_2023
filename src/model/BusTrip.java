package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BusTrip {
    private static int idCounter = 1000;
    private int id;
    private Station departureStation;
    private Station destinationStation;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private int capacity;
    private BusDriver driver;
    private ArrayList<Ticket> tickets;

    public int getId() {
        return id;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(Station destinationStation) throws Exception {
        if(departureStation != destinationStation) {
        	this.destinationStation = destinationStation;
        }
        else throw new Exception("Stacijas nevar sakrist!");
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) throws Exception {
        if(departureDateTime.isAfter(LocalDateTime.now())){
        	this.departureDateTime = departureDateTime;
        }
        else throw new Exception("Nepareizs laiks! Laiks jau pagajis");
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) throws Exception {
    	if(arrivalDateTime.isAfter(departureDateTime)){
        	this.arrivalDateTime = arrivalDateTime;
        }
        else throw new Exception("Nepareizs laiks! Noradiet laiku pec izbrauksanas");
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public BusDriver getDriver() {
        return driver;
    }

    public void setDriver(BusDriver driver) throws Exception {
        if (!driver.getCategories().contains(BusCategory.largebus) && this.capacity > 30) { //if doesn't contain largebus and capacity > 30
            throw new Exception("Vaditajs nevar vadit lielo autobusu!");
        } 
        else if (!driver.getCategories().contains(BusCategory.largebus) && !driver.getCategories().contains(BusCategory.minibus) && this.capacity <= 30) { //if no largebus and no minibus and capacity =< 30
            throw new Exception("Vaditajs nevar vadit mazo autobusu!");
        } 
        else {
            this.driver = driver;
        }
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) throws Exception {
        if (this.tickets.size() == this.capacity) {
            throw new Exception("Buss pilns!");
        }
        if (ticket.isVIP()) {
            this.tickets.add(0, ticket); //VIP tickets get priority and are added at the front of array
        } else {
            this.tickets.add(ticket);
        }
    }
    
    public void changeDriver(BusDriver driver) throws Exception{
        setDriver(driver);
    }
    
    public BusTrip(Station departureStation, Station destinationStation, LocalDateTime departureDateTime,
                   LocalDateTime arrivalDateTime, int capacity, BusDriver driver) throws Exception {
        this.id = idCounter++;
        setDepartureStation(departureStation);
        setDestinationStation(destinationStation);
        setDepartureDateTime(departureDateTime);
        setArrivalDateTime(arrivalDateTime);
        setCapacity(capacity);
        setDriver(driver);
    }
}
