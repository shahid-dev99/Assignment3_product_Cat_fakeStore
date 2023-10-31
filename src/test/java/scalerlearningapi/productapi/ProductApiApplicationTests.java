package scalerlearningapi.productapi;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import scalerlearningapi.productapi.Models.AssocModel.Adress;
import scalerlearningapi.productapi.Models.AssocModel.AdressRepository;
import scalerlearningapi.productapi.Models.AssocModel.Student;
import scalerlearningapi.productapi.Models.AssocModel.StudentRepository;

@SpringBootTest
class ProductApiApplicationTests {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AdressRepository adressRepository;
    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void testStudentEagerLazy(){
        Student st = new Student();
        st.setName("Shahid");
        st.setRoll(1);
        Adress ad = new Adress();
        ad.setCity("Bdl");
        ad.setPinCode(4321);
        st.setAdress(ad);
        studentRepository.save(st);
        adressRepository.save((ad));

    }
}
