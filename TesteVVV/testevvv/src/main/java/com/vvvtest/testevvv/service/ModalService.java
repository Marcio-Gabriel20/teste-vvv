package com.vvvtest.testevvv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Modal atualizaModal(Long id, String status) {

        Modal modal = modalRepository.findById(id).orElse(null);
        modal.setStatus(status);
        modalRepository.save(modal);
        return modal;

    }

}