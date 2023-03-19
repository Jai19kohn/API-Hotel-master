package com.example.Hotel.ApiHotel.Controller;
import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.Models.EnderecoDAO;
import com.example.Hotel.ApiHotel.DTO.EnderecoDTO;
import com.example.Hotel.ApiHotel.repository.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EnderecoController {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping("/endereco")
    public ResponseEntity<EnderecoDTO> addEndereco(@RequestBody @Valid EnderecoDTO e){
        EnderecoDAO enderecoPer = enderecoRepository.save(e.toDAO());
        return new ResponseEntity<EnderecoDTO>(enderecoPer.toDTO(), HttpStatus.CREATED);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<EnderecoDTO>> gelEndereco(){
        return ResponseEntity.ok().body(enderecoRepository.findAll()
                .stream()
                .map(EnderecoDAO -> EnderecoDAO.toDTO())
                .collect(Collectors.toList()));
    }
    @GetMapping("/endereco/{id}")
    public ResponseEntity<EnderecoDTO>getEnderecoPorId(@PathVariable("id") Long id){
        Optional<EnderecoDAO> endereço = enderecoRepository.findById(id);
        if (endereço.isPresent()) {
            return new ResponseEntity<EnderecoDTO>(endereço.get().toDTO(), HttpStatus.OK);
        }else {
                return ResponseEntity.notFound().build();
            }
        }



    @PutMapping("/endereco/{id}/atualizar")
    public ResponseEntity<EnderecoDTO> atualizeOEndereco(@PathVariable("id") Long id,@RequestBody EnderecoDTO e){
        e.setIdEndereco(id);
        System.out.println("");
        EnderecoDAO atualizarEndereco= enderecoRepository.save(e.toDAO());
        return new ResponseEntity<EnderecoDTO>(atualizarEndereco.toDTO(), HttpStatus.OK);

    }

    @DeleteMapping ("/endereco/{id}/deletar")
    public ResponseEntity<ClientDTO> deleteClientById(@PathVariable("id") Long id){
        EnderecoDAO endereco = new EnderecoDAO();
        endereco.setid();
        enderecoRepository.delete(endereco);
        return ResponseEntity.noContent().build();
    }


}
