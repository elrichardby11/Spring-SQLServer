package cl.cft.conexionDB.service;

import cl.cft.conexionDB.entities.Department;
import cl.cft.conexionDB.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentService;

    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }

    public Optional<Department> getDepartmentById(Integer id) {
        return departmentService.findById(id);
    }

    public Department saveDepartment(Department department) {
        return departmentService.save(department);
    }

    public void deleteDepartment(Integer id) { departmentService.deleteById(id); }

    public boolean existDepartment(Integer id) {
        return this.departmentService.existsById(id);
    }

}
