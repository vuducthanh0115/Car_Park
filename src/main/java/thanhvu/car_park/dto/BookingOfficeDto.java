package thanhvu.car_park.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class BookingOfficeDto {
    Long officeId;

    LocalDate endContractDeadline;
    @NotEmpty(message = "Name can not be empty")
    @Pattern(regexp = "^[a-zA-Z" +
            "àáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$",
            message = "Name must match the following format : Nguyen Van A ...")
    String officeName;
    @NotEmpty(message = "Phone number can not be empty")
    @Pattern(
            regexp = "^(?:0|\\+84)[0-9]{8,9}$",
            message = "Phone number must match the following format: 090xxxxxxx or 091xxxxxxx or (84) + 90xxxxxxx or " +
                    "(84) + 91xxxxxxx"
    )
    String officePhone;
    @NotEmpty(message = "Place can not be empty")
    String officePlace;
    @NotNull(message = "Price can not be null")
    Long officePrice;

    LocalDate startContractDeadline;
    @NotNull(message = "TripId can not be null")
    Long officeTripId;

    public BookingOfficeDto() {
    }

    public BookingOfficeDto(Long officeId, LocalDate endContractDeadline, String officeName, String officePhone, String officePlace, Long officePrice, LocalDate startContractDeadline, Long officeTripId) {
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

    public Long getOfficeTripId() {
        return officeTripId;
    }

    public void setOfficeTripId(Long officeTripId) {
        this.officeTripId = officeTripId;
    }
}
