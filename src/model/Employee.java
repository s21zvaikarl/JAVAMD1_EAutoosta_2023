package model;

import java.time.LocalDate;

public class Employee extends Person{
	private LocalDate contractDate;
	private String contractNumber;
	
    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) throws Exception {
        LocalDate minDate = LocalDate.of(2023, 3, 24);
        if (contractDate.isBefore(minDate)) {
            throw new Exception("Liguma datums nevar but pirms 24.03.2023.");
        }
        this.contractDate = contractDate;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    private void setContractNumber() {
        String year = Integer.toString(contractDate.getYear()); //liguma gads
        String nameInitial = getName().substring(0, 1); 		//varda pirmais burts
        String surnameInitial = getSurname().substring(0, 1); 	//uzvarda pirmais burts
        this.contractNumber = year + "_" + nameInitial + "_" + surnameInitial; //2023_A_A
    }
    
    public Employee(String name, String surname, String personCode, LocalDate contractDate) throws Exception {
        super(name, surname, personCode);
        setContractDate(contractDate);
        setContractNumber();
    }
}
