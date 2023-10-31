package scalerlearningapi.productapi.Models.AssocModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress,Long> {
    Adress save( Adress adress);
}
