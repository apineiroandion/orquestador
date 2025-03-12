package org.example.orquestador.client;

import org.example.orquestador.model.BookRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-books-mongo", url = "http://localhost:8082/api/books")
public interface BookMongoClient {
    @PostMapping
    void saveBook(@RequestBody BookRequest book);
}

