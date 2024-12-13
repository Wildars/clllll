package com.example.classwork.service;

import com.example.classwork.entity.PhoneBook;
import com.example.classwork.repository.PhoneBookRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    private final PhoneBookRepository phoneBookRepository;

    public PhoneBookServiceImpl(PhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    @Override
    public PhoneBook create(PhoneBook request) {
        return phoneBookRepository.save(request);
    }

    @Override
    public PhoneBook findById(Long id) {
        return phoneBookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PhoneBook entry not found with ID: " + id));
    }

    @Override
    public PhoneBook update(PhoneBook request, Long id) {
        PhoneBook existingPhoneBook = findById(id);
        existingPhoneBook.setFio(request.getFio());
        existingPhoneBook.setPhoneNumber(request.getPhoneNumber());
        existingPhoneBook.setAddress(request.getAddress());
        existingPhoneBook.setEmail(request.getEmail());
        return phoneBookRepository.save(existingPhoneBook);
    }

    @Override
    public List<PhoneBook> findAll() {
        return phoneBookRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!phoneBookRepository.existsById(id)) {
            throw new EntityNotFoundException("PhoneBook entry not found with ID: " + id);
        }
        phoneBookRepository.deleteById(id);
    }
}