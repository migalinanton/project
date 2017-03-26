package ru.ncedu.java.tasks;

/**
 * Created by Антон on 25.03.2017.
 */
public class EmployeeImpl implements Employee {
    private int salary;
    private String FirstName;
    private String LastName;
    Employee manager;
    public EmployeeImpl (){
        salary = 1000;
    }
    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void increaseSalary(int value) {
        salary+=value;
    }

    @Override
    public String getFirstName() {
        return FirstName;
    }

    @Override
    public void setFirstName(String firstName) {
        FirstName = new String(firstName);
    }

    @Override
    public String getLastName() {
        return LastName;
    }

    @Override
    public void setLastName(String lastName) {
        LastName = new String(lastName);
    }

    @Override
    public String getFullName() {
        return FirstName+" "+LastName;
    }

    @Override
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String getManagerName() {
        if (manager!=null) return manager.getFullName();
        return "No manager";
    }

    @Override
    public Employee getTopManager() {
        if (manager==null) return this;
        else return this.manager.getTopManager();
    }
}
