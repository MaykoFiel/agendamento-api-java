package com.banco.agendamento.repositores;

import com.banco.agendamento.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    //Verificar se já existe um agendamento naquele horário exato
    boolean existsByDateTime (LocalDateTime dateTime);



}
