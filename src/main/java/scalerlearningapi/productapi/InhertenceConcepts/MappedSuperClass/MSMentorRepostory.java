package scalerlearningapi.productapi.InhertenceConcepts.MappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MSMentorRepostory extends JpaRepository<Mentor,Long> {
    Mentor save(Mentor m);
    Mentor findMentorById(Long id);
}
