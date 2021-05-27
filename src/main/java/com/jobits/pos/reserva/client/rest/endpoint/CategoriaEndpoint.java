/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.client.rest.endpoint;

import com.jobits.pos.reserva.core.domain.Categoria;
import com.jobits.pos.reserva.core.module.ReservaCoreModule;
import com.jobits.pos.reserva.core.usecase.CategoriaUseCase;
import com.root101.clean.core.app.usecase.AbstractUseCaseImpl;
import java.beans.PropertyChangeListener;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class CategoriaEndpoint extends AbstractUseCaseImpl implements CategoriaUseCase {

    private final CategoriaUseCase uc = ReservaCoreModule.getInstance().getImplementation(CategoriaUseCase.class);

    @Override
    @GetMapping("/count")
    public int count() throws RuntimeException {
        return uc.count();
    }

    @Override
    @PostMapping("/create")
    public Categoria create(@RequestBody Categoria t) throws RuntimeException {
        return uc.create(t);
    }

    @Override
    public Categoria destroy(Categoria t) throws RuntimeException {
        return uc.destroy(t);
    }

    @Override
    @PostMapping("/destroy/{id}")
    public Categoria destroyById(@PathVariable Object o) throws RuntimeException {
        return uc.destroyById(o);
    }

    @Override
    @PostMapping("/edit")
    public Categoria edit(@RequestBody Categoria t) throws RuntimeException {
        return uc.edit(t);
    }

    @Override
    @GetMapping("/findall")
    public List<Categoria> findAll() throws RuntimeException {
        return uc.findAll();
    }

    @Override
    @GetMapping("/find/{id}")
    public Categoria findBy(@PathVariable Object o) throws RuntimeException {
        return uc.findBy(o);
    }

}
