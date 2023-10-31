package scalerlearningapi.productapi.Models.AssocModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student save(Student student);
    Student findStudentById(Long id);
}
