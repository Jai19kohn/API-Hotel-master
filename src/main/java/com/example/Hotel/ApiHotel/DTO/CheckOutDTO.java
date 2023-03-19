package com.example.Hotel.ApiHotel.DTO;
import com.example.Hotel.ApiHotel.Models.CheckOutDAO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.Entity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckOutDTO {
    private Long idCheckIn;
    private Long idReserva;
    private double precoTotal;
    private String horarioSai;
    private int quantidadeCart;

    public CheckOutDAO toDAO(){
        return CheckOutDAO
                .builder()
                .idCheckIn(idCheckIn)
                .idReserva(idReserva)
                .precoTotal(precoTotal)
                .horarioSai(horarioSai)
                .quantidadeCart(quantidadeCart)
                .build();
    }

}
