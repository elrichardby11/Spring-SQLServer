package cl.cft.conexionDB.repository;

import cl.cft.conexionDB.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
