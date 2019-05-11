package pl.borowik.dao;

import pl.borowik.model.RentDate;

public interface RentDateRepository {

    void save(RentDate rentDate);
    RentDate findById(int theId);
}
