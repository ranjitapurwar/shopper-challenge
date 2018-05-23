package com.shopper.ws.service.impl;

import com.shopper.ws.dto.Shopper;
import com.shopper.ws.service.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ranjitapurwar on 5/22/18.
 */
public class ShopperServiceImpl implements ShopperService {


    public ShopperServiceImpl() {

    }


    public Shopper createShopper(Shopper shopperDTO) {
        //Shopper shopper = null;

        // Return back the shopper
        return shopperDTO;
    }

    public Shopper getShopper(Long id) {
        Shopper shopper = null;
        return shopper;
    }

}
