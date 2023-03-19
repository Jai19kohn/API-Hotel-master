package com.example.Hotel.ApiHotel.repository;
import com.example.Hotel.ApiHotel.Models.CheckInDAO;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CheckInRepository extends  JpaRepository<CheckInDAO, Long> {

}
