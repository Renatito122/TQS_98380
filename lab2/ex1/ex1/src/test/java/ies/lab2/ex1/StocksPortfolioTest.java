package ies.lab2.ex1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class StocksPortfolioTest
{

    @Test
    public void getTotalValue()
    {
        IStockmarketService mockedMarketService = mock(IStockmarketService.class);
        StocksPortfolio sp = new StocksPortfolio();
        sp.setStockmarket(mockedMarketService);

        sp.addStock(new Stock("IBM", 3));
        sp.addStock(new Stock("MEO", 10));

        when(mockedMarketService.lookUpPrice("IBM")).thenReturn(15.0);
        when(mockedMarketService.lookUpPrice("MEO")).thenReturn(5.5);
        
        double totalValue = sp.getTotalValue();

        assertEquals(totalValue,100);
        assertThat(totalValue, is(100.0));

        verify(mockedMarketService).lookUpPrice("IBM");
        verify(mockedMarketService).lookUpPrice("MEO");
    }

   

}
