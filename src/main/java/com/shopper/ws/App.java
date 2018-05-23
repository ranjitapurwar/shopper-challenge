/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopper.ws;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by rpurwar on 5/22/18.
 */
@ApplicationPath("api")
public class App extends ResourceConfig {

    public App(){
        // Register resources and providers using package-scanning.
        packages("com.shopper.ws");
    }

}
