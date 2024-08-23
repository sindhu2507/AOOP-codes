package singleResponsibilityPrinciple;

public class SalaryCalculator {
	public double calculateSalary(Employee employee) {
        if (employee.getRole().equals("Developer")) {
            return 80000;
        } else if (employee.getRole().equals("Manager")) {
            return 100000;
        }
        return 50000; // Default salary
    }
}
