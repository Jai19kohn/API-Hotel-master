package com.example.Hotel.ApiHotel.Models;

import com.example.Hotel.ApiHotel.DTO.CheckInDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckInDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCheckIn;
    private Long idReserva;
    private Long idCliente;
    private String horarioCheg;
    private int quantCart;

    public CheckInDTO toDTO(){
        return CheckInDTO
                .builder()
                .idCheckIn(idCheckIn)
                .idReserva(idReserva)
                .idCliente(idCliente)
                .horarioCheg(horarioCheg)
                .quantCart(quantCart)
                .build();
    }
}