package com.example.Hotel.ApiHotel.Controller;
import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.Models.CheckInDAO;
import com.example.Hotel.ApiHotel.DTO.CheckInDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.repository.CheckInRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CheckInController {
    @Autowired
    private CheckInRepository checkInRepository;
    public List<CheckInDTO> CheckinList = new ArrayList<CheckInDTO>();

    public HashMap<Integer, CheckInDTO> check = new HashMap<Integer, CheckInDTO>();

    @PostMapping("/checkin")
    public ResponseEntity<CheckInDTO> addCheckin (@RequestBody @Valid CheckInDTO cc){
        CheckInDAO checkinPersisted = checkInRepository.save(cc.toDAO());
        String tamanhoLista = String.valueOf(check.size());
        System.out.println("Cliente Cadastrado com SUCESSO!"+ " - Quantidade de Clientes: " + tamanhoLista);
        System.out.println( cc.toString());
        return new ResponseEntity<CheckInDTO>(checkinPersisted.toDTO(), HttpStatus.CREATED);
}
    @PutMapping ("/checkin/{idCheckIn}/atualizar")
    public ResponseEntity<CheckInDTO> updateClient(@PathVariable("id") Long idCheckIn, @RequestBody CheckInDTO cc){
        cc.setIdCheckIn(idCheckIn);
        System.out.println("");
        CheckInDAO checkinUpdate = checkInRepository.save(cc.toDAO());
        return new ResponseEntity<CheckInDTO>(checkinUpdate.toDTO(), HttpStatus.OK);

        }
           @GetMapping("/checlInAll")
      public ResponseEntity<List<CheckInDTO>> getAllCheckIn(){
        return ResponseEntity.ok().body(checkInRepository.findAll()
                .stream()
                .map(checkInDAO -> checkInDAO.toDTO())
                .collect(Collectors.toList())
        );
    }
    @GetMapping("/checkIn/{idCheckIn}")
    public ResponseEntity<CheckInDTO> getCheckInById(@PathVariable("idCheckIn")long idCheckIn ){
        Optional<CheckInDAO> check = checkInRepository.findById(idCheckIn);
        if (check.isPresent()){
            return new ResponseEntity<CheckInDTO>(check.get().toDTO(),HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/checkIn/{idCheckIn}/excluir")
    public ResponseEntity<CheckInDTO> deleteCheckInById(@PathVariable("idCheckIn") long idCheckIn){
        CheckInDAO check = new CheckInDAO();
        check.setIdCheckIn(idCheckIn);
        checkInRepository.delete(check);
        return ResponseEntity.noContent().build();
    }






           }










