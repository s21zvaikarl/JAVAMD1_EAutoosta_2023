package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class BusDriver extends Employee {
	private ArrayList<BusCategory> categories; //array for bus categories
	private int yearOfExperience; //stazs
	
	public int getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
	
	public ArrayList<BusCategory> getCategories() {
		return categories;
	}

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

	public BusDriver(String name, String surname, String personCode, LocalDate contractDate, ArrayList<BusCategory> categories, int yearsOfExperience) throws Exception {
		super(name, surname, personCode, contractDate);
		this.categories = categories;
		setYearOfExperience(yearsOfExperience);
	}
}
