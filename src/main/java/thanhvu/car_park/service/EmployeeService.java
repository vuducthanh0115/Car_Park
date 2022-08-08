package thanhvu.car_park.service;

import thanhvu.car_park.dto.EmployeeDto;
import thanhvu.car_park.dto.EmployeeListDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeListDto> getAllEmployee();

    boolean createNewEmployee(EmployeeDto employeeDto);

    boolean editEmployee(EmployeeDto employeeDto, Long employeeId);

    boolean deleteEmployeeById(Long employeeId);

}
