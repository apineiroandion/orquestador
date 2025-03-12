package org.example.orquestador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private Long id;
    private String titulo;
    private Double preco;
}

