package model;

import java.time.LocalDate;

public class Cashier extends Employee {
    private static int nextId = 100;
    private int id;
    
    public int getId() {
        return id;
    }

	public Cashier(String name, String surname, String personCode, LocalDate contractDate) throws Exception {
		super(name, surname, personCode, contractDate);
		this.id = nextId;
        nextId++; //every next person gets +1 id number
	}
}
