package thanhvu.car_park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import thanhvu.car_park.dto.EmployeeListDto;
import thanhvu.car_park.entity.Employee;

import java.time.LocalDate;
import java.util.List;

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /*@Query(value = """
            select employee_id as employeeId, employee_address as employeeAddress, gender, employee_birthdate as employeeBirthDate, employee_email as employeeEmail, employee_name as employeeName, department, employee_phone as employeePhone, employee_account as employeeAccount from employee;
            """, nativeQuery = true)
    List<EmployeeListDto> getAllEmployee();*/
    @Query("""
            select e from Employee e
            """)
    List<EmployeeListDto> getAllEmployee();

    @Query("""
            select e from Employee e
            where e.employeeId = ?1
            """)
    EmployeeListDto findEmployeeById(Long employeeId);

    @Query("""
            select count(e) from Employee e
            where e.employeeAccount = ?1
            """)
    Integer countAccount(String employeeAccount);

    @Query("""
            select count(e) from Employee e
            where e.employeeEmail = ?1
            """)
    Integer countEmail(String employeeEmail);

    @Query("""
            select count(e) from Employee e
            where e.employeePhone = ?1
            """)
    Integer countPhone(String employeePhone);

    @Query("""
            select count(e) from Employee e
            where e.employeeId = ?1
            """)
    Integer countId(Long employeeId);

    @Modifying
    @Query(value = """
            insert into employee(employee_account, department, employee_address, employee_birthdate, employee_email, employee_name, employee_phone, employee_password, gender) values (?1,?2,?3,?4,?5,?6,?7,?8,?9)
            """, nativeQuery = true)
    void createNewEmployee(String employeeAccount, String department, String employeeAddress, LocalDate employeeBirthdate, String employeeEmail, String employeeName, String employeePhone, String employeePassword, String gender);

    @Modifying
    @Query(value = """
            update employee as e 
            set e.employee_account = ?1 , e.department = ?2 , e.employee_address = ?3 , e.employee_birthdate = ?4 , e.employee_email = ?5 , e.employee_name = ?6 , e.employee_phone = ?7 , e.employee_password = ?8 , e.gender = ?9 
            where e.employee_id = ?10 ;
            """, nativeQuery = true)
    void editEmployee(String employeeAccount, String department, String employeeAddress, LocalDate employeeBirthdate, String employeeEmail, String employeeName, String employeePhone, String employeePassword, String gender, Long employeeId);

    @Modifying
    @Query(value = """
            delete from employee 
            where employee_id = ?1 ;
            """, nativeQuery = true)
    void deleteEmployeeById(Long employeeId);

}
