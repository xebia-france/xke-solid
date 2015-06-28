package fr.xebia.xke.solid.isp.model;

import java.math.BigDecimal;

/**
 * Created by sbuisson on 19/06/2015.
 */
public interface Order {
    String getReferenceItem();

    void setReferenceItem(String referenceItem);

    int getQuantity();

    void setQuantity(int quantity);

    String getDeliveryAddress();

    void setDeliveryAddress(String deliveryAddress);

    String getFacturationAddress();

    void setFacturationAddress(String facturationAddress);

    BigDecimal getMontant();


    BigDecimal getPrixUnitaire();

    void setPrixUnitaire(BigDecimal prixUnitaire);

}
