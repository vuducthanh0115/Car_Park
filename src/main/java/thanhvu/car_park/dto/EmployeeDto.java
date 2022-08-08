package thanhvu.car_park.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class EmployeeDto {
    private Long employeeId;
    @NotEmpty(message = "Account can not be empty")
    @Size(max = 50, min = 5, message = "Length: 5 -> 50 characters")
    private String employeeAccount;
    @NotEmpty(message = "Department can not be empty")
    @Size(max = 10, min = 2, message = "Length: 2 -> 10 characters")
    private String department;
    @NotEmpty(message = "Địa chỉ can not be empty")
    @Size(max = 200, message = "Maximun length 200 characters")
    private String employeeAddress;

    private LocalDate employeeBirthdate;
    @NotEmpty(message = "Email can not be empty")
    @Pattern(regexp = "^\\S+@\\S+\\.\\S+$",
            message = "Email must match the following format: abc@xyz")
    private String employeeEmail;
    @NotEmpty(message = "Name can not be empty")
    //@Size(min = 2, max = 25, message = "Tên tối thiểu 2 kí tự tối đa 25 kí tự")
    @Pattern(regexp = "^[a-zA-Z" +
            "àáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$",
            message = "Name must match the following fomat: Nguyen Van A ...")
    private String employeeName;
    @NotEmpty(message = "Phone number can not be empty")
    @Pattern(
            regexp = "^(?:0|\\+84)[0-9]{8,9}$",
            message = "Phone number must match the following fomat: 090xxxxxxx or 091xxxxxxx or (84) + 90xxxxxxx or " +
                    "(84) + " +
                    "91xxxxxxx"
    )
    private String employeePhone;
    @NotEmpty(message = "Password can not be empty")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[A-Z])(?=.*[-\\#\\$\\.\\%\\&\\*\\@])(?=.*[a-zA-Z]).{8,16}$",
            message = "Password: 8 -> 16 characters, contains at least 1 uppercase, contains at least 1 lowercase, " +
                    "contains at least 1 special characters")
    private String employeePassword;
    @NotEmpty(message = "Gender can not be empty")
    @Size(max = 1, min = 1, message = "Gender must match the following fomat:  0 - Female or 1 - Male")
    private String gender;

    public EmployeeDto() {
    }

    public EmployeeDto(Long employeeId, String employeeAccount, String department, String employeeAddress, LocalDate employeeBirthdate, String employeeEmail, String employeeName, String employeePhone, String employeePassword, String gender) {
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
