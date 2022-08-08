package thanhvu.car_park.dto;

import java.time.LocalDate;

public interface EmployeeListDto {
    Long getEmployeeId();
    String getEmployeeAccount();
    String getDepartment();
    String getEmployeeAddress();
    LocalDate getEmployeeBirthdate();
    String getEmployeeEmail();
    String getEmployeeName();
    String getEmployeePhone();
    String getGender();
}
