package pl.borowik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.borowik.model.RentDate;

public interface RentDateRepository {

    void save(RentDate rentDate);
    RentDate findById(int theId);

}
