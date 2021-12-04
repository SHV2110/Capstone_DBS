package com.teamfour.capstoneprojectdbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamfour.capstoneprojectdbs.beans.Custodian;

import java.util.List;
@Repository
public interface CustodianRepository extends JpaRepository<Custodian, String> {
    List<Custodian> findAll();
}
