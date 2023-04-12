package com.vvvtest.testevvv.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vvvtest.testevvv.dto.ModalDTO;
import com.vvvtest.testevvv.dto.ModalUpdateForm;
import com.vvvtest.testevvv.model.Modal;
import com.vvvtest.testevvv.service.ModalService;

@RestController
@RequestMapping("/modal")
public class ModalController {
    
    @Autowired
    private ModalService modalService;

    @GetMapping
    public List<Modal> buscarTodos() {
        
        return modalService.buscarTodos();

    }

    @GetMapping("/{id}")
    public Optional<Modal> buscarPorId(@PathVariable("id") Long id) {

        return modalService.buscarPorId(id);

    }

    @PostMapping
    public Modal salvar(@RequestBody Modal modal) {
        
        return modalService.salvar(modal);

    }

    @PutMapping("/{id}")
    public ModalDTO atualizaStatusById(@RequestBody ModalUpdateForm form, @PathVariable("id") Long id) {

        return modalService.atualizarStatusById(form, id);

    }

    @DeleteMapping("/{id}")
    public String deletarPorId(@PathVariable("id") Long id) {

        return modalService.deletarPorId(id);

    }

}