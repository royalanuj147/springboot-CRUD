package com.example.Bank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Integer>
{
List<Bank> findByName(String name);
}
