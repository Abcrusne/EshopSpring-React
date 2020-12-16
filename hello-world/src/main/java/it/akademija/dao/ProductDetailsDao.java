package it.akademija.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.entities.ProductDetails;

public interface ProductDetailsDao extends JpaRepository<ProductDetails, Integer> {

}
