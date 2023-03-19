package com.example.Hotel.ApiHotel.DTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {
    private Long id;

    private String senha;

    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String aniversario;


    public ClientDAO toDAO(){
        return ClientDAO
                .builder()
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


