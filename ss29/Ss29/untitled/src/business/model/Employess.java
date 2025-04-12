package business.model;

import business.service.department.DepartmentService;
import validate.EmployessValidator;
import validate.StringRule;
import validate.Validator;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Employess {
    private String idEmployess;
    private String nameEmployess;
    private String emailEmployess;
    private String phoneEmployess;
    private int levelEmployess;
    private double salaryEmployess;
    private LocalDate birthdayEmployess;
    private String addressEmployess;
    private Sex sex;
    private StatusEmployess statusEmployess;
    private  int departmentID;

    public Employess() {
    }

    public Employess(String idEmployess, String emailEmployess, String nameEmployess, String phoneEmployess, int levelEmployess, double salaryEmployess, LocalDate birthdayEmployess, Sex sex, String addressEmployess, StatusEmployess statusEmployess) {
        this.idEmployess = idEmployess;
        this.emailEmployess = emailEmployess;
        this.nameEmployess = nameEmployess;
        this.phoneEmployess = phoneEmployess;
        this.levelEmployess = levelEmployess;
        this.salaryEmployess = salaryEmployess;
        this.birthdayEmployess = birthdayEmployess;
        this.sex = sex;
        this.addressEmployess = addressEmployess;
        this.statusEmployess = statusEmployess;
    }

    public String getIdEmployess() {
        return idEmployess;
    }

    public void setIdEmployess(String idEmployess) {
        this.idEmployess = idEmployess;
    }

    public String getNameEmployess() {
        return nameEmployess;
    }

    public void setNameEmployess(String nameEmployess) {
        this.nameEmployess = nameEmployess;
    }

    public String getEmailEmployess() {
        return emailEmployess;
    }

    public void setEmailEmployess(String emailEmployess) {
        this.emailEmployess = emailEmployess;
    }

    public String getPhoneEmployess() {
        return phoneEmployess;
    }

    public void setPhoneEmployess(String phoneEmployess) {
        this.phoneEmployess = phoneEmployess;
    }

    public int getLevelEmployess() {
        return levelEmployess;
    }

    public void setLevelEmployess(int levelEmployess) {
        this.levelEmployess = levelEmployess;
    }

    public double getSalaryEmployess() {
        return salaryEmployess;
    }

    public void setSalaryEmployess(double salaryEmployess) {
        this.salaryEmployess = salaryEmployess;
    }

    public LocalDate getBirthdayEmployess() {
        return birthdayEmployess;
    }

    public void setBirthdayEmployess(LocalDate birthdayEmployess) {
        this.birthdayEmployess = birthdayEmployess;
    }

    public String getAddressEmployess() {
        return addressEmployess;
    }

    public void setAddressEmployess(String addressEmployess) {
        this.addressEmployess = addressEmployess;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public StatusEmployess getStatusEmployess() {
        return statusEmployess;
    }

    public void setStatusEmployess(StatusEmployess statusEmployess) {
        this.statusEmployess = statusEmployess;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void inputData(Scanner sc, DepartmentService departmentService){
        this.idEmployess = EmployessValidator.validateId(sc,"(E)\\w{5}");
        this.nameEmployess = Validator.validateString(sc,"vui lòng nhập tên nhân viên",new StringRule(150,15));
        this.emailEmployess = EmployessValidator.validateEmail(sc,"vui lòng nhập email");
        this.addressEmployess = Validator.validateString(sc,"vui lòng nhập đại chỉ ",new StringRule(255,0));
        this.phoneEmployess = EmployessValidator.validatePhone(sc,"vui lòng nhập số điện thoạt");
        this.sex = Validator.validateStatus(sc,"vui lòng nhập giới tính",Sex.class);
        this.levelEmployess =Integer.parseInt(sc.nextLine());
        this.salaryEmployess = Double.parseDouble(sc.nextLine());
        this.statusEmployess = Validator.validateStatus(sc,"vui lòng nhập trạng thái của nhân viên ",StatusEmployess.class);
        this.birthdayEmployess=EmployessValidator.validateDate("vui lòng nhập ngày sinh ",sc);
        this.departmentID =inputdepartmentId(sc,departmentService);
    }
    public int inputdepartmentId(Scanner sc, DepartmentService departmentService){
        List<Department> list= departmentService.getall();
        list.stream().forEach(e->{
            System.out.println("id "+e.getIdDepartment() + "tên "+e.getNameDepartment());
        });
        do {
            System.out.println("vui lòng nhập id của phòng ban");
            Integer id = Integer.parseInt(sc.nextLine());
            Department check = departmentService.getById(id);
            if (check != null ){
                return check.getIdDepartment();
            }else{
                System.out.println("không timf thấy id ");
            }
        }while (true);
    }

    @Override
    public String toString() {
        return "Employess{" +
                "idEmployess='" + idEmployess + '\'' +
                ", nameEmployess='" + nameEmployess + '\'' +
                ", emailEmployess='" + emailEmployess + '\'' +
                ", phoneEmployess='" + phoneEmployess + '\'' +
                ", levelEmployess=" + levelEmployess +
                ", salaryEmployess=" + salaryEmployess +
                ", birthdayEmployess=" + birthdayEmployess +
                ", addressEmployess='" + addressEmployess + '\'' +
                ", sex=" + sex +
                ", statusEmployess=" + statusEmployess +
                '}';
    }
}
