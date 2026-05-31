package ra.hwss0901.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.hwss0901.model.dto.request.EmployeeCreateDTO;
import ra.hwss0901.model.entity.Department;
import ra.hwss0901.model.entity.Employee;
import ra.hwss0901.repository.DepartmentRepository;
import ra.hwss0901.repository.EmployeeRepository;
import ra.hwss0901.service.EmployeeService;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public Employee createEmployee(EmployeeCreateDTO employeeCreateDTO) {
        Department department = departmentRepository.findById(employeeCreateDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng ban ID " + employeeCreateDTO.getDepartmentId()));
        Employee employee = Employee.builder()
                .fullName(employeeCreateDTO.getFullName())
                .email(employeeCreateDTO.getEmail())
                .phone(employeeCreateDTO.getPhone())
                .salary(employeeCreateDTO.getSalary())
                .department(department)
                .build();
        return employeeRepository.save(employee);
    }
}
