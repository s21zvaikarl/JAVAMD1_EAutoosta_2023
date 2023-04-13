package model;

import java.time.LocalDateTime;

public class Ticket {
    private static int idCounter = 1000;
    private int id;
    private LocalDateTime purchaseDateTime;
    private double discount;
    private double price;
    private Cashier cashier;
    private boolean isVIP;

    public int getId() {
        return id;
    }

    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    public void setPurchaseDateTime() {
        this.purchaseDateTime = LocalDateTime.now();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) throws Exception {
        if(discount >= 0 && discount <= 100) {
        	this.discount = discount;
        }
        else throw new Exception("Atlaide janorada procentos!");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP() {
        isVIP = true;
    }
    
    public Ticket(double discount, double price, Cashier cashier, boolean isVIP) throws Exception {
        setPurchaseDateTime();
        setDiscount(discount);
        setPrice(price);
        setCashier(cashier);
        this.isVIP = isVIP;
        this.id = ++idCounter;
    }
}
