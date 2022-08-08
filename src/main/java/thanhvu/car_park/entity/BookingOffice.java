package thanhvu.car_park.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookingoffice")
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id", nullable = false)
    private Long officeId;

    @Column(name = "end_contract_deadline")
    private LocalDate endContractDeadline;

    @Column(name = "office_name", length = 50, nullable = false)
    private String officeName;

    @Column(name = "office_phone", length = 11, nullable = false)
    private String officePhone;

    @Column(name = "office_place", length = 50, nullable = false)
    private String officePlace;

    @Column(name = "office_price", nullable = false)
    private Long officePrice;

    @Column(name = "start_contract_deadline")
    private LocalDate startContractDeadline;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "trip_id", nullable = false, foreignKey = @ForeignKey(name = "fk_trip_id_booking"))
    private Trip officeTripId;

    public BookingOffice() {
    }

    public BookingOffice(Long officeId, LocalDate endContractDeadline, String officeName, String officePhone, String officePlace, Long officePrice, LocalDate startContractDeadline, Trip officeTripId) {
        this.officeId = officeId;
        this.endContractDeadline = endContractDeadline;
        this.officeName = officeName;
        this.officePhone = officePhone;
        this.officePlace = officePlace;
        this.officePrice = officePrice;
        this.startContractDeadline = startContractDeadline;
        this.officeTripId = officeTripId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public LocalDate getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(LocalDate endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public Long getOfficePrice() {
        return officePrice;
    }

    public void setOfficePrice(Long officePrice) {
        this.officePrice = officePrice;
    }

    public LocalDate getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(LocalDate startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }
}
