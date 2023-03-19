package com.example.Hotel.ApiHotel.Models;

import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Cliente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class ClientDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long idEndereco;
    private String senha;

    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String aniversario;

    public ClientDTO toDTO (){
        return ClientDTO.builder()
                .id(id)
                .senha(senha)
                .nome(nome)
                .sobrenome(sobrenome)
                .telefone(telefone)
                .email(email)
                .aniversario(aniversario)
                .build();
    }
}