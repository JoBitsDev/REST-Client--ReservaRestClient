/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.client.rest.endpoint;

import com.jobits.pos.reserva.core.domain.Categoria;
import com.jobits.pos.reserva.core.domain.Reserva;
import com.jobits.pos.reserva.core.module.ReservaCoreModule;
import com.jobits.pos.reserva.core.usecase.CategoriaUseCase;
import com.jobits.pos.reserva.core.usecase.ReservaUseCase;
import com.root101.clean.core.app.usecase.CRUDUseCase;
import java.time.LocalDate;
import java.util.List;
import org.jobits.pos.client.rest.assembler.CrudModelAssembler;
import org.jobits.pos.client.rest.endpoint.CrudRestServiceTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
@RestController
@RequestMapping(path = "/reserva")
public class ReservaEndpoint extends CrudRestServiceTemplate<Reserva> {

    public static final String CREATE_PATH = "/register-reserva";
    public static final String EDIT_PATH = "/edit/{id}";
    public static final String RESERVAS_DISP_PATH = "/find-disponibles/{aaaa}/{mm}/{dd}";

    @Override
    public CrudModelAssembler<Reserva> getAssembler() {
        throw new UnsupportedOperationException("Bad Request");
    }

    @Override
    public ReservaUseCase getUc() {
        return ReservaCoreModule.getInstance().getImplementation(ReservaUseCase.class);
    }

    @PostMapping(CREATE_PATH)
    ResponseEntity<Reserva> newReserva(@RequestBody Reserva newReserva) {
        var r = getUc().create(newReserva);
        return ResponseEntity.ok(r);
    }

    @PutMapping(EDIT_PATH)
    ResponseEntity<Reserva> editReserva(@PathVariable("id") int idReserva, @RequestBody Reserva editedReserva) {
        var oldReserva = getUc().findBy(idReserva);
        if (oldReserva == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id no valido");

        }
        var r = getUc().edit(editedReserva);
        return ResponseEntity.ok(r);
    }
    
    @GetMapping(RESERVAS_DISP_PATH)
    ResponseEntity<List<Reserva>> findDisponibles(@PathVariable("aaaa") int aaaa,
            @PathVariable("mm") int mm,
            @PathVariable("dd") int dd) {
       
        return ResponseEntity.ok(getUc().getReservasDisponibles(LocalDate.of(aaaa, mm, dd)));
    }
    
    

}
