package com.vvvtest.testevvv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vvvtest.testevvv.model.Modal;
import com.vvvtest.testevvv.repository.ModalRepository;

@Service
public class ModalService {
    
    @Autowired
    private ModalRepository modalRepository;

    public List<Modal> buscarTodos() {

        return modalRepository.findAll();

    }

    public Modal salvar(Modal modal) {
        
        return modalRepository.save(modal);

    }

}