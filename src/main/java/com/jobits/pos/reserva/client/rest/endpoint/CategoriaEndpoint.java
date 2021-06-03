/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.client.rest.endpoint;

import com.jobits.pos.reserva.core.domain.Categoria;
import com.jobits.pos.reserva.core.module.ReservaCoreModule;
import com.jobits.pos.reserva.core.usecase.CategoriaUseCase;
import com.root101.clean.core.app.usecase.CRUDUseCase;
import org.jobits.pos.client.rest.assembler.CrudModelAssembler;
import org.jobits.pos.client.rest.endpoint.CrudRestServiceTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
@RestController
@RequestMapping(path = "/categoria")
public class CategoriaEndpoint extends CrudRestServiceTemplate<Categoria> {

    private final CrudModelAssembler<Categoria> a = new CrudModelAssembler<Categoria>(CategoriaEndpoint.class) {
        @Override
        public Object getId(Categoria entity) {
            return entity.getIdcategoria();
        }
    };

    @Override
    public CrudModelAssembler<Categoria> getAssembler() {
        return a;
    }

    @Override
    public CRUDUseCase<Categoria> getUc() {
        return ReservaCoreModule.getInstance().getImplementation(CategoriaUseCase.class);
    }

    }
