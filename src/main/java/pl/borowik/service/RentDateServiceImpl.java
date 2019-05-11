package pl.borowik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.borowik.dao.RentDateRepository;
import pl.borowik.model.RentDate;

@Service
public class RentDateServiceImpl implements RentDateService{

    private RentDateRepository rentDateRepository;

    @Autowired
    public RentDateServiceImpl(RentDateRepository theRentDateRepository){
        rentDateRepository= theRentDateRepository;
    }


    @Override
    public void save(RentDate rentDate) {

        rentDateRepository.save(rentDate);

    }

    @Override
    public RentDate findById(int theId) {

        return rentDateRepository.findById(theId);
    }
}
