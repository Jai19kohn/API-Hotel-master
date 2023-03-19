package com.example.Hotel.ApiHotel.Controller;
import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.Models.ReservaDAO;
import com.example.Hotel.ApiHotel.DTO.ReservaDTO;

import com.example.Hotel.ApiHotel.repository.ReservaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;
    public List<ReservaDTO> ReservaList = new ArrayList<ReservaDTO>();

    public HashMap<Integer, ReservaDTO> reserva = new HashMap<Integer, ReservaDTO>();

   // @PostMapping("/reservas")
    //public ResponseEntity<ReservaDTO> addReserva (@RequestBody @Valid ReservaDTO r){
      //  ReservaDAO reservaPersisted = reservaRepository.save(r.toDAO());
        //String tamanhoLista = String.valueOf(reserva.size());
       // System.out.println("Cliente Cadastrado com SUCESSO!"+ " - Quantidade de Clientes: " + tamanhoLista);
       // System.out.println( r.toString());
        //return new ResponseEntity<ReservaDTO>(reservaPersisted.toDTO(), HttpStatus.CREATED);
    //}
@PostMapping("/reserva")
public ResponseEntity<ReservaDTO> addReserva(@RequestBody @Valid ReservaDTO r){
    ReservaDAO reservaPersisted = reservaRepository.save(r.toDAO());
    String tamanhoLista = String.valueOf(reserva.size());
    System.out.println("Cliente Cadastrado com SUCESSO!"+ " - Quantidade de Clientes: " + tamanhoLista);
    System.out.println( r.toString());
    return new ResponseEntity<ReservaDTO>(reservaPersisted.toDTO(),HttpStatus.CREATED);

}

    @PutMapping ("/reservas/{idReserva}/atualizar")
    public ResponseEntity<ReservaDTO> updateClient(@PathVariable("idReserva") Long idReserva, @RequestBody ReservaDTO r){
        r.setIdReserva(idReserva);
        System.out.println("");
        ReservaDAO reservaUpdate = reservaRepository.save(r.toDAO());
        return new ResponseEntity<ReservaDTO>(reservaUpdate.toDTO(), HttpStatus.OK);
    }
    @GetMapping("/reservaAll")
    public ResponseEntity<List<ReservaDTO>> getAllReserva(){
    return ResponseEntity.ok().body(reservaRepository.findAll()
            .stream()
            .map(reservaDAO -> reservaDAO.toDTO())
            .collect(Collectors.toList()));
    }

    @GetMapping ("/reserva/{idReserva}")
    public ResponseEntity<ReservaDTO> getResevaByIdReserva(@PathVariable("idReserva") Long idReserva){
        Optional<ReservaDAO> reserva = reservaRepository.findById(idReserva);
        if (reserva.isPresent()){
            return new ResponseEntity<ReservaDTO>(reserva.get().toDTO(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping ("/reserva/{idReserva}/excluir")
    public ResponseEntity<ReservaDTO> deleteReservaByIdReserva(@PathVariable("idReserva") Long idReserva){
        ReservaDAO reserva = new ReservaDAO();
        reserva.setIdReserva(idReserva);
        reservaRepository.delete(reserva);
        return ResponseEntity.noContent().build();
    }


    }



