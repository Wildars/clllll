package com.example.classwork.service;

import com.example.classwork.entity.PhoneBook;

import java.util.List;

public interface PhoneBookService {
    PhoneBook create(PhoneBook request);
    PhoneBook findById(Long id);
    PhoneBook update(PhoneBook request, Long id);
    List<PhoneBook> findAll() ;
    void deleteById(Long id);
}
