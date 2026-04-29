package com.banco.agendamento.services;


import com.banco.agendamento.dto.AppointmentDTO;
import com.banco.agendamento.entities.Appointment;
import com.banco.agendamento.repositores.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;


    public String salvarAgendamento(AppointmentDTO dto) {

        if (repository.existsByDateTime(dto.dateTime())) {
            return "Erro: Horário indisponivel";
        }

        Appointment app = new Appointment();
        app.setDateTime(dto.dateTime());
        app.setProfessionalName(dto.professionalName());
        app.setClientName(dto.clientName());
        app.setStatus("CONFIRMADO");

        repository.save(app);
        return "Agendamento realizado com sucesso!";
    }

    // Listar os agendamentos no banco de dados
    public List<Appointment> listartodos() {
        return repository.findAll();
    }

    // Atualizando o agendamento
    public  String atualizar(Long id, AppointmentDTO dto) {
        return repository.findById(id).map(app -> {copyDtoToEntity(dto, app);
        repository.save(app);
        return "Agendamento atualizado!";
        }).orElse("Erro agendamento não encontrado");
    }

    // Removendo o agendamento
    public String deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Agendamento apagado com sucesso!.";
        }
        return "Erro: ID naõ encontrado";
    }

    private void copyDtoToEntity(AppointmentDTO dto , Appointment entity) {
        entity.setDateTime(dto.dateTime());
        entity.setProfessionalName(dto.professionalName());
        entity.setClientName(dto.clientName());
    }

}

