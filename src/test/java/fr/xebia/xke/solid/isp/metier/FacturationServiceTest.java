package fr.xebia.xke.solid.isp.metier;

import fr.xebia.xke.solid.isp.model.DematerialisedOrder;
import fr.xebia.xke.solid.isp.model.MainOrder;
import fr.xebia.xke.solid.isp.model.Order;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class FacturationServiceTest {
    BillingService billingService;

    @Before
    public void setUp() {
        billingService = new BillingService();
    }

    @Test
    public void shouldChargeSNCF() {
        //Given
        Order order = new MainOrder();
        order.setFacturationAddress("SNCF");
        order.setPrixUnitaire(BigDecimal.valueOf(1));
        order.setQuantity(1);

        //When
        String actual = billingService.writeBill(order);

        //Then
        assertEquals("SNCF must pay 1 euros", actual);
    }

    @Test
    public void shouldChargeSFR() {
        //Given
        Order order = new DematerialisedOrder();
        order.setFacturationAddress("SFR");
        order.setPrixUnitaire(BigDecimal.valueOf(666));

        //When
        String actual = billingService.writeBill(order);

        //Then
        assertEquals("SFR must pay 666 euros", actual);
    }


}