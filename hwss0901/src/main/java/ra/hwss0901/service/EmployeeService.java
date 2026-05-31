package ra.hwss0901.service;

import ra.hwss0901.model.dto.request.EmployeeCreateDTO;
import ra.hwss0901.model.entity.Employee;

public interface EmployeeService {
    Employee createEmployee(EmployeeCreateDTO employeeCreateDTO);
}
