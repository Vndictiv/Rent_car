package pl.borowik.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rent_date")
public class RentDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private int rentId;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "rent_date")
    private Date rentDate;

    @Column(name = "return_date")
    private Date returnDate;

    public RentDate(){

    }

    public RentDate(User user, Car car, Date rentDate, Date returnDate) {
        this.user = user;
        this.car = car;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car carId) {
        this.car = carId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "RentDate{" +
                "rentId=" + rentId +
                ", user=" + user +
                ", car=" + car +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
