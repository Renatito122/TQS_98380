package ies.lab2.ex1;

import java.util.List;
import java.util.ArrayList;

public class StocksPortfolio {

    private IStockmarketService stockmarket;
    private List<Stock> stocks = new ArrayList<Stock>();


    public IStockmarketService getStockmarket() {
        return this.stockmarket;
    }

    public void setStockmarket(IStockmarketService stockmarket) {
        this.stockmarket = stockmarket;
    }

    public List<Stock> getStocks() {
        return this.stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public void addStock(Stock stock){
        this.stocks.add(stock);
    }

    public double getTotalValue(){
        double total=0;
        for (Stock st : stocks) {
            total+= stockmarket.lookUpPrice(st.getLabel())*st.getQuantity();
        }
        return total;
    }
}
