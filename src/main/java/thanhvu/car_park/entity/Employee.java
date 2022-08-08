package thanhvu.car_park.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "employee_account", nullable = false, length = 50)
    private String employeeAccount;

    @Column(name = "department", nullable = false, length = 10)
    private String department;

    @Column(name = "employee_address", nullable = false, length = 50)
    private String employeeAddress;

    @Column(name = "employee_birthdate", nullable = false)
    private LocalDate employeeBirthdate;

    @Column(name = "employee_email", nullable = false, length = 50)
    private String employeeEmail;

    @Column(name = "employee_name", nullable = false, length = 50)
    private String employeeName;

    @Column(name = "employee_phone", nullable = false, length = 10)
    private String employeePhone;

    @Column(name = "employee_password", nullable = false, length = 20)
    private String employeePassword;

    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    public Employee(Long employeeId, String employeeAccount, String department, String employeeAddress, LocalDate employeeBirthdate, String employeeEmail, String employeeName, String employeePhone, String employeePassword, String gender) {
        this.employeeId = employeeId;
        this.employeeAccount = employeeAccount;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthdate = employeeBirthdate;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeePassword = employeePassword;
        this.gender = gender;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Employee() {
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public LocalDate getEmployeeBirthdate() {
        return employeeBirthdate;
    }

    public void setEmployeeBirthdate(LocalDate employeeBirthdate) {
        this.employeeBirthdate = employeeBirthdate;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
