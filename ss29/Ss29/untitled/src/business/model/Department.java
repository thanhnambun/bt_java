package business.model;

import validate.StringRule;
import validate.Validator;

import java.util.Scanner;

public class Department {
    public static int idSequance;
    private int idDepartment;
    private String nameDepartment;
    private String description;
    private Status statusDepartment;

    public Department() {
        this.idDepartment =++idDepartment;
    }

    public Department(String nameDepartment, String description, Status statusDepartment) {
        this.nameDepartment = nameDepartment;
        this.idDepartment = ++idDepartment;
        this.description = description;
        this.statusDepartment = statusDepartment;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatusDepartment() {
        return statusDepartment;
    }

    public void setStatusDepartment(Status statusDepartment) {
        this.statusDepartment = statusDepartment;
    }

    public void inputData(Scanner sc){
        this.idDepartment = ++idDepartment;
        this.nameDepartment = Validator.validateString(sc,"vui lòng nhập tên phòng ban",new StringRule(100,10));
        this.description=Validator.validateString(sc,"vui lòng nhập mô tả phòng ban",new StringRule(255,0));
        this.statusDepartment = Validator.validateStatus(sc,"vui lòng nhập trạng thái phòng ban ",Status.class);
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", nameDepartment='" + nameDepartment + '\'' +
                ", description='" + description + '\'' +
                ", statusDepartment=" + statusDepartment +
                '}';
    }
}
