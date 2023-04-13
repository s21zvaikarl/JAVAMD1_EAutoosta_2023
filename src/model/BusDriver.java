package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class BusDriver extends Employee {
	private ArrayList<BusCategory> categories; //array for bus categories
	private int yearOfExperience; //stazs
	
	public void addCategory(BusCategory category) throws Exception {
		//checks if the category exists
		if (!categories.contains(category)) {
    		categories.remove(category);
        }
		else throw new Exception("Kategorija neeksiste!");
    }

    public void removeCategory(BusCategory category) throws Exception {
    	if (!categories.contains(category)) {
    		categories.remove(category);
        }
		else throw new Exception("Kategorija neeksiste!");
    }
    
    public BusDriver(String name, String surname, String personCode, LocalDate contractDate, String contractNumber, ArrayList<BusCategory> categories, int yearsOfExperience) {
    		super(name, surname, personCode, contractDate, contractNumber);
    		this.categories = categories;
    		this.yearOfExperience = yearsOfExperience;
    }

}
