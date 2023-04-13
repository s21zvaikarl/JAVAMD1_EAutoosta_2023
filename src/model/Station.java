package model;

import java.time.LocalTime;

public class Station {
    private City city;
    private String stationName;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private static int nextId = 1;
    private int id;
    
    public int getId() {
        return id;
    }
    
    public City getCity() {
        return city;
    }
    
    public String getStationName() {
        return stationName;
    }
    
    public LocalTime getOpeningTime() {
        return openingTime;
    }
    
    public LocalTime getClosingTime() {
        return closingTime;
    }
    
    public void setCity(City city) {
		this.city = city;
    }

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public void setOpeningTime(LocalTime openingTime) {
		this.openingTime = openingTime;
	}

	public void setClosingTime(LocalTime closingTime) {
		this.closingTime = closingTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Station(City city, String stationName, LocalTime openingTime, LocalTime closingTime) {
        setCity(city);
        setStationName(stationName);
        setOpeningTime(openingTime);
        setClosingTime(closingTime);
        this.id = nextId;
        nextId++;
    }
}