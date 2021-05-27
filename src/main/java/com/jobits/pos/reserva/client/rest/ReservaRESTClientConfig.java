/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.client.rest;

import com.jobits.pos.reserva.core.module.ReservaCoreModule;
import com.jobits.pos.reserva.repo.module.ReservaRepoModule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */

@Component
public class ReservaRESTClientConfig {

    public static final String BASE_PACKAGE = "com.jobits.pos.reserva.client.rest";

    static {
        ReservaCoreModule.init(ReservaRepoModule.init());
    }

}
