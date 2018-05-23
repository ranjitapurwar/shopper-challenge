package com.shopper.ws.service;



import com.shopper.ws.dto.Shopper;

/**
 * Created by rpurwar on 5/22/18.
 */
public interface ShopperService {
    Shopper createShopper(Shopper shopper);
    Shopper getShopper(Long id);
}
