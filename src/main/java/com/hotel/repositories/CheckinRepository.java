package com.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.model.Checkin;

@Repository
public interface CheckinRepository extends JpaRepository<Checkin, Integer> {

}