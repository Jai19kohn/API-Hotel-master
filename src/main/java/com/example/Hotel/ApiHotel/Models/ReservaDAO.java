package com.example.Hotel.ApiHotel.Models;

import com.example.Hotel.ApiHotel.DTO.ReservaDTO;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class ReservaDAO {
    private Long idReserva;
    private Long idQuarto;
    private String dataInicio;
    private String dataFim;
    private int quantPes;
    private double preco;

    public ReservaDTO toDTO(){
        return ReservaDAO
                .builder()
                .idReserva(idReserva)
                .idQuarto(idQuarto)
                .dataInicio(dataInicio)
                .dataFim(dataFim)
                .quantPes(quantPes)
                .preco(preco)
                .build().toDTO();
    }
}
