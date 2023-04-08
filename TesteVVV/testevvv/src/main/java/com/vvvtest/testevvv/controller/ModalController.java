package com.vvvtest.testevvv.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vvvtest.testevvv.model.Modal;
import com.vvvtest.testevvv.repository.ModalRepository;
import com.vvvtest.testevvv.service.ModalService;

@RestController
@RequestMapping("/modal")
public class ModalController {
    
    @Autowired
    private ModalService modalService;
    
    @Autowired
    private ModalRepository modalRepository;

    @GetMapping
    public List<Modal> buscarTodos() {
        
        return modalService.buscarTodos();

    }

    @PostMapping
    public Modal salvar(@RequestBody Modal modal) {
        
        return modalService.salvar(modal);

    }

    @PutMapping("/status/{id}")
    public Modal atualizaModal(@PathVariable Long id, @RequestParam Modal modal) {

        Modal modalAtual = modalRepository.findById(id).get();
        BeanUtils.copyProperties(modal, modalAtual, "id", "name");
        return modalRepository.save(modalAtual);

    }

}