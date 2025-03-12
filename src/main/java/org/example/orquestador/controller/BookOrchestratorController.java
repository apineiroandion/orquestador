package org.example.orquestador.controller;

import lombok.RequiredArgsConstructor;
import org.example.orquestador.client.BookMongoClient;
import org.example.orquestador.client.BookPostgresClient;
import org.example.orquestador.model.BookRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookOrchestratorController {

    private final BookPostgresClient bookPostgresClient;
    private final BookMongoClient bookMongoClient;

    @PostMapping
    public ResponseEntity<String> saveBook(@RequestBody BookRequest book) {
        try {
            bookPostgresClient.saveBook(book);
            bookMongoClient.saveBook(book);
            return ResponseEntity.ok("Libro guardado en ambas bases de datos.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar el libro: " + e.getMessage());
        }
    }
}


