package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cashier extends Employee {
    private static int nextId = 100;
    private int id;
    private static ArrayList<Cashier> cashiers;
    
    public int getId() {
        return id;
    }

	public Cashier(String name, String surname, String personCode, LocalDate contractDate) throws Exception {
		super(name, surname, personCode, contractDate);
		this.id = nextId;
        nextId++; //every next person gets +1 id number
	}
	
	public static void addCashier(Cashier cashier) {
        if (cashier != null) {
            cashiers.add(cashier);
        }
    }
	
    //find cashier by person code
    public static Cashier findCashierByPersonCode(String personCode) {
        for (Cashier cashier : cashiers) {
            if (cashier.getPersonCode().equals(personCode)) {
                return cashier;
            }
        }
        return null;
    }

    //change cashier data by person code
    public static void updateCashier(String personCode, String newName, String newSurname, LocalDate newDate) throws Exception {
        Cashier cashier = findCashierByPersonCode(personCode);
        if (cashier != null) {
            cashier.setName(newName);
            cashier.setSurname(newSurname);
            cashier.setContractDate(newDate);
        }
    }

    //Delete cashier by person code
    public static void deleteCashierByPersonCode(String personCode) {
        Cashier cashier = findCashierByPersonCode(personCode);
        if (cashier != null) {
            cashiers.remove(cashier);
        }
    }

    // return all cashiers
    public static ArrayList<Cashier> getAllCashiers() {
        return cashiers;
    }
	
}
