package com.example.Salon.Model.Repository;

import com.example.Salon.Model.Entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customers,Integer> {
    @Query("SELECT password FROM Customers WHERE email = :email" )
    String findPasswordByEmail(@Param("email") String email);

    @Query("select case when count(email) > 0 then true else false end from Customers where email = :email")
    Boolean existsByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM  Customers  where email=:email",nativeQuery = true)
    Optional<Customers> findByEmail(@Param("email") String email) ;

}
