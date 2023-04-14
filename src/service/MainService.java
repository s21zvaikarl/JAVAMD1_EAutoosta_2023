package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;

import model.BusTrip;
import model.Employee;
import model.Station;
import model.BusCategory;
import model.BusDriver;
import model.Cashier;
import model.City;

public class MainService {
	private static ArrayList<BusTrip> allBusTrips = new ArrayList<>();
	private static ArrayList<Employee> allEmployees = new ArrayList<>();
	private static ArrayList<Station> allStations = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			Cashier c1 = new Cashier("Jānis", "Bērziņš", "111111-20000", LocalDate.of(2023, 5, 1));
			Cashier.addCashier(c1);
			Cashier c2 = new Cashier("Līga", "Priedīte", "151111-30000", LocalDate.of(2023, 5, 1));
			Cashier.addCashier(c2);
			System.out.println(Cashier.findCashierByPersonCode("111111-20000"));
			System.out.println(c1);
			Cashier.updateCashier("111111-20000", "Jānis", "Alksnītis", LocalDate.of(2024, 5, 1));
			System.out.println(Cashier.getAllCashiers());
			Cashier.deleteCashierByPersonCode("111111-20000");
			System.out.println(Cashier.getAllCashiers());
			
			BusDriver bd1 = new BusDriver("Kārlis", "Zvaigzne", "100000-22222", LocalDate.of(2023, 4, 14), null, 5);
			bd1.addCategory(BusCategory.minibus);
			allEmployees.addAll(Arrays.asList(bd1, c1));
			
			Station st1 = new Station(City.Ventspils, "Ventspils Autoosta", LocalTime.of(7,0), LocalTime.of(22, 0));
			Station st2 = new Station(City.Liepaja, "Liepajas Autoosta", LocalTime.of(6,30), LocalTime.of(23, 0));
			allStations.addAll(Arrays.asList(st1, st2));
			
			BusTrip route1 = new BusTrip(st1, st2, LocalDateTime.of(2023, 4, 14, 18, 35), LocalDateTime.of(2023, 4, 14, 20, 05), 45, bd1);
			BusTrip route2 = new BusTrip(st2, st1, LocalDateTime.of(2023, 4, 14, 20, 35), LocalDateTime.of(2023, 4, 14, 22, 05), 45, bd1);
			allBusTrips.addAll(Arrays.asList(route1, route2));
			
			
			

		}
		catch (Exception e) {
			System.out.println(e);
			}
		}
}
