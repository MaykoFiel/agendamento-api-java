package com.banco.agendamento.controllers;


import com.banco.agendamento.dto.AppointmentDTO;
import com.banco.agendamento.entities.Appointment;
import com.banco.agendamento.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public String criar(@RequestBody @Valid AppointmentDTO dto) {
        return service.salvarAgendamento(dto);
    }
    @GetMapping
    public List<Appointment> buscarTodos() {
        return service.listartodos();
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable Long id, @RequestBody @Valid AppointmentDTO dto) {
        return service.atualizar(id, dto);
    }


    @DeleteMapping("/{id}")
        public String excluir(@PathVariable Long id) {
        return service.deletar(id);
    }

}
