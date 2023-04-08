package com.vvvtest.testevvv.dto;

import com.vvvtest.testevvv.model.Modal;

import lombok.Data;

@Data
public class ModalDTO {
    
    private Long id;
    private String nome;
    private String status;

    public ModalDTO() {}

    public ModalDTO(Modal modal) {
        this.id = modal.getId();
        this.nome = modal.getNome();
        this.status = modal.getStatus();
    }

}