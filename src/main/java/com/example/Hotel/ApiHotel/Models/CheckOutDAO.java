package com.example.Hotel.ApiHotel.Models;
import com.example.Hotel.ApiHotel.DTO.CheckOutDTO;
import jakarta.persistence.*;
import lombok.*;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class CheckOutDAO {
    private Long idCheckIn;
    private Long idReserva;
    private double precoTotal;
    private String horarioSai;
    private int quantidadeCart;

    public CheckOutDTO toDTO(){
        return CheckOutDTO
                .builder()
                .idCheckIn(idCheckIn)
                .idReserva(idReserva)
                .precoTotal(precoTotal)
                .horarioSai(horarioSai)
                .quantidadeCart(quantidadeCart)
                .build();
    }
}
