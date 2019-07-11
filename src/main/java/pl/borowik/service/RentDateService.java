package pl.borowik.service;

import pl.borowik.model.RentDate;

public interface RentDateService {

    void save(RentDate rentDate);
    RentDate findById(int theId);

}
