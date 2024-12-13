package com.example.classwork.controller;

import com.example.classwork.entity.PhoneBook;
import com.example.classwork.service.PhoneBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/phonebook")
public class PhoneBookController {

    private final PhoneBookService phoneBookService;

    public PhoneBookController(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    @PostMapping
    public ResponseEntity<PhoneBook> create(@RequestBody PhoneBook request) {
        PhoneBook createdPhoneBook = phoneBookService.create(request);
        return new ResponseEntity<>(createdPhoneBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneBook> findById(@PathVariable Long id) {
        PhoneBook phoneBook = phoneBookService.findById(id);
        return ResponseEntity.ok(phoneBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneBook> update(@RequestBody PhoneBook request, @PathVariable Long id) {
        PhoneBook updatedPhoneBook = phoneBookService.update(request, id);
        return ResponseEntity.ok(updatedPhoneBook);
    }

    @GetMapping
    public ResponseEntity<List<PhoneBook>> findAll() {
        List<PhoneBook> phoneBooks = phoneBookService.findAll();
        return ResponseEntity.ok(phoneBooks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        phoneBookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
