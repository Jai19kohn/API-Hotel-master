package com.example.Hotel.ApiHotel.DTO;
import com.example.Hotel.ApiHotel.Models.CheckInDAO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CheckInDTO {
    private Long idCheckIn;
    private Long idReserva;
    private Long idCliente;
    private String horarioCheg;
    private int quantCart;

public CheckInDAO toDAO(){
    return CheckInDAO
            .builder()
            .idCheckIn(idCheckIn)
            .idReserva(idReserva)
            .idCliente(idCliente)
            .horarioCheg(horarioCheg)
            .quantCart(quantCart)
            .build();
}
}