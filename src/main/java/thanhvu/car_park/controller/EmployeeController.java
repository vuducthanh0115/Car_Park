package thanhvu.car_park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thanhvu.car_park.dto.EmployeeDto;
import thanhvu.car_park.dto.EmployeeListDto;
import thanhvu.car_park.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<EmployeeListDto>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(
            @Valid @RequestBody EmployeeDto employeeDto
    ) {
        employeeService.createNewEmployee(employeeDto);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editEmployee(
            @Valid @RequestBody EmployeeDto employeeDto,
            @PathVariable("id") Long id
    ) {
        employeeService.editEmployee(employeeDto, id);
        return ResponseEntity.ok("Cập nhật thành công");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(
            @PathVariable("id") Long id
    ) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Xoá thành công");
    }
}
