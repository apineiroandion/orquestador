package org.example.orquestador.client;

import org.example.orquestador.model.BookRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-books-postgres", url = "http://localhost:8081/api/books")
public interface BookPostgresClient {
    @PostMapping
    void saveBook(@RequestBody BookRequest book);
}
