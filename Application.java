package employee_package;

import java.util.List;
import com.hms.dao.EmployeeDaoImpl;

public class Application {

	public static void main(String[] args) {

		EmployeeDaoImpl dao = new EmployeeDaoImpl();

		// instantiating class
		EmployeeDetails e = new EmployeeDetails();
		// e.setId(346);
		e.setFirstName("bhaskar");
		e.setLastName("karnam");
		e.setAge(25);
		Address homeaddr = new Address();
		homeaddr.setCity("channassen");
		homeaddr.setPincode(55317);
		e.setHomeAddress(homeaddr);
		Address officeaddr = new Address();
		officeaddr.setCity("downtown");
		officeaddr.setPincode(55405);
		e.setOfficeAddress(officeaddr);

		// using save collections
		PhoneNumber num1 = new PhoneNumber();
		num1.setAreaCode(612);
		num1.setPhoneNumber(8178297);
		PhoneNumber num2 = new PhoneNumber();
		num2.setAreaCode(952);
		num2.setPhoneNumber(8473955);

		e.getListOfPhoneNumbers().add(num1);
		e.getListOfPhoneNumbers().add(num2);

		// using collection and arraylist
		// proof of stay object
		ProofOfStay pos1 = new ProofOfStay();
		pos1.setIdType("driving_license");
		pos1.setIdOrigin("minneapolis");

		e.getProofOfResidence().add(pos1);

		dao.saveEmployoee(e);

		// working with OnetoOne Mapping
		Bank bankDetails = new Bank();
		bankDetails.setBankName("b");
		e.setBankDetails(bankDetails);
		dao.savebank(bankDetails);

		// working with OnetoMany Mapping
		Vehicle vehicleData1 = new Vehicle();
		vehicleData1.setVehicleName("swift");
		Vehicle vehicleData2 = new Vehicle();
		vehicleData2.setVehicleName("nissan");

		e.getVehicle().add(vehicleData1);
		e.getVehicle().add(vehicleData2);
		dao.saveVehicle(vehicleData1);
		dao.saveVehicle(vehicleData2);

	/*	// working with manytomany mapping
		FoodTableReservation FTR1 = new FoodTableReservation();
		FTR1.setTableFloor(1);

		FoodTableReservation FTR2 = new FoodTableReservation();
		FTR2.setTableFloor(34);

		e.getFoodtablereservation().add(FTR1);
		e.getFoodtablereservation().add(FTR2);
		FTR1.getUserList().add(e);
		FTR2.getUserList().add(e);
		dao.saveFood(FTR1);
		dao.saveFood(FTR2);   */

		
		
		
		
		
		
		
		
		
		
		
		// Retrieving data
		EmployeeDetails empDetails1 = dao.getEmployeeById(1);
		System.out.println("Employee Last Name before update: " + empDetails1.getLastName());
		// updating row value
		empDetails1.setLastName("Rao");
		dao.updateEmployoee(empDetails1);
		System.out.println("Employee Last Name after update: " + empDetails1.getLastName());

		List<EmployeeDetails> employees = dao.getEmployees();
		System.out.println("Total Employees are: " + employees.size());
		for (EmployeeDetails emp : employees) {
			System.out.println("First Name: " + emp.getFirstName());
			System.out.println("last Name: " + emp.getLastName());

		}

	}
}
