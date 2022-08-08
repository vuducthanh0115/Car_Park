package thanhvu.car_park.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalTime;

public class TicketDto {
    Long ticketId;
    LocalTime bookingTime;
    @NotEmpty(message = "Name can not be empty")
    @Pattern(regexp = "^[a-zA-Z" +
            "àáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$",
            message = "Name must match the following format : Nguyễn Văn A ...")
    String customerName;
    @NotNull(message = "LicensePlate can not be null")
    String licensePlateId;
    @NotNull(message = "Trip id can not be null")
    Long ticketTripId;

    public TicketDto() {
    }

    public TicketDto(Long ticketId, LocalTime bookingTime, String customerName, String licensePlateId, Long ticketTripId) {
        this.ticketId = ticketId;
        this.bookingTime = bookingTime;
        this.customerName = customerName;
        this.licensePlateId = licensePlateId;
        this.ticketTripId = ticketTripId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLicensePlateId() {
        return licensePlateId;
    }

    public void setLicensePlateId(String licensePlateId) {
        this.licensePlateId = licensePlateId;
    }

    public Long getTicketTripId() {
        return ticketTripId;
    }

    public void setTicketTripId(Long ticketTripId) {
        this.ticketTripId = ticketTripId;
    }
}

