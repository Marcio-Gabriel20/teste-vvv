package com.vvvtest.testevvv.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vvvtest.testevvv.dto.ModalDTO;
import com.vvvtest.testevvv.dto.ModalUpdateForm;
import com.vvvtest.testevvv.model.Modal;
import com.vvvtest.testevvv.repository.ModalRepository;

@Service
public class ModalService {
    
    @Autowired
    private ModalRepository modalRepository;

    private Modal convertToBusiness(ModalUpdateForm form) {

        Modal modal = new Modal();
        modal.setStatus(form.getStatus());
        return modal;

    }

    private ModalDTO convertToDTO(Modal modal) {

        ModalDTO dto = new ModalDTO();
        dto.setId(modal.getId());
        dto.setStatus(modal.getStatus());
        return dto;

    }

    private static List<ModalDTO> convertListToDTO(List<Modal> modais) {

        return modais.stream().map(ModalDTO::new).collect(Collectors.toList());

    }

    public List<Modal> buscarTodos() {

        return modalRepository.findAll();

    }

    public Modal salvar(Modal modal) {
        
        return modalRepository.save(modal);

    }

    public ModalDTO atualizarStatusById(ModalUpdateForm form, Long id) {

        Optional<Modal> op = modalRepository.findById(id);

        if(op.isPresent()) {
            
            Modal obj = op.get();

            if(form.getStatus() != null) {

                obj.setStatus(form.getStatus());
                
            }

            modalRepository.save(obj);
            return convertToDTO(obj);

        }

        return null;

    }

}