package thanhvu.car_park.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thanhvu.car_park.dto.EmployeeDto;
import thanhvu.car_park.dto.EmployeeListDto;
import thanhvu.car_park.exception.DuplicateRecordException;
import thanhvu.car_park.exception.NotFoundException;
import thanhvu.car_park.repository.EmployeeRepository;
import thanhvu.car_park.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeListDto> getAllEmployee() {
        List<EmployeeListDto> e = employeeRepository.getAllEmployee();
        if (!e.isEmpty()) {
            return e;
        }
        throw new NotFoundException("Không có employee nào");
    }

    @Override
    public boolean createNewEmployee(EmployeeDto employeeDto) {
        if (employeeRepository.countAccount(employeeDto.getEmployeeAccount()) < 1 &&
                employeeRepository.countEmail(employeeDto.getEmployeeEmail()) < 1 &&
                employeeRepository.countPhone(employeeDto.getEmployeePhone()) < 1
        ) {
            employeeRepository.createNewEmployee(
                    employeeDto.getEmployeeAccount(),
                    employeeDto.getDepartment(),
                    employeeDto.getEmployeeAddress(),
                    employeeDto.getEmployeeBirthdate(),
                    employeeDto.getEmployeeEmail(),
                    employeeDto.getEmployeeName(),
                    employeeDto.getEmployeePhone(),
                    employeeDto.getEmployeePassword(),
                    employeeDto.getGender()
            );
            return true;
        }
        throw new DuplicateRecordException("Tài khoản hoặc email hoặc số điện thoại bị trùng");
    }

    @Override
    public boolean editEmployee(EmployeeDto employeeDto, Long employeeId) {
        if (employeeRepository.countId(employeeId) > 0) {
            employeeRepository.editEmployee(
                    employeeDto.getEmployeeAccount(),
                    employeeDto.getDepartment(),
                    employeeDto.getEmployeeAddress(),
                    employeeDto.getEmployeeBirthdate(),
                    employeeDto.getEmployeeEmail(),
                    employeeDto.getEmployeeName(),
                    employeeDto.getEmployeePhone(),
                    employeeDto.getEmployeePassword(),
                    employeeDto.getGender(),
                    employeeId
            );
            return true;
        }
        throw new NotFoundException("Employee không tồn tại");
    }

    @Override
    public boolean deleteEmployeeById(Long employeeId) {
        if (employeeRepository.countId(employeeId) > 0) {
            employeeRepository.deleteEmployeeById(employeeId);
            return true;
        }
        throw new NotFoundException("Employee không tồn tại");
    }
}
