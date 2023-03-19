package com.example.Hotel.ApiHotel.Controller;

import com.example.Hotel.ApiHotel.DTO.CheckInDTO;
import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.Models.CheckInDAO;
import com.example.Hotel.ApiHotel.Models.CheckOutDAO;
import com.example.Hotel.ApiHotel.DTO.CheckOutDTO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import com.example.Hotel.ApiHotel.repository.CheckOutRepository;
import com.example.Hotel.ApiHotel.repository.ClientRepository;
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
public class CheckOutController {

    @Autowired
    private CheckOutRepository checkOutRepository;
    public List<CheckOutDTO> CheckOutList= new ArrayList<CheckOutDTO>();

    public HashMap<Integer, CheckOutDTO> checkout = new HashMap<Integer, CheckOutDTO>();

    @PostMapping("/checkout")
    public ResponseEntity<CheckOutDTO> addCheckOut (@RequestBody @Valid CheckOutDTO c){
        CheckOutDAO checkOutPersisted = checkOutRepository.save(c.toDAO());
        String tamanhoLista = String.valueOf(checkout.size());
        System.out.println("Cliente Cadastrado com SUCESSO!"+ " - Quantidade de Clientes: " + tamanhoLista);
        System.out.println( c.toString());
        return new ResponseEntity<CheckOutDTO>(checkOutPersisted.toDTO(), HttpStatus.CREATED);
    }
    @PutMapping ("/checkout/{idCheckout}/atualizar")
    public ResponseEntity<CheckOutDTO> updateCheckOut(@PathVariable("idCheckIn") Long idCheckIn, @RequestBody CheckOutDTO c){
        c.setIdCheckIn(idCheckIn);
        System.out.println("");
        CheckInDAO checkoutUpdate = checkOutRepository.save(c.toDAO());
        return new ResponseEntity<CheckOutDTO>(checkoutUpdate.toDTO(), HttpStatus.OK);
    }



}
