package s1.mar.model;

import s1.mar.Manifest;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "stockname")
    private String stockName;
    @Column(name = "stockprice")
    private double stockPrice;
    private String organization;
    @Column(name = "trade_currency")
    @Enumerated(EnumType.STRING)
    private Manifest.Currency tradeCurrency;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String name) {
        this.stockName = name;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double price) {
        this.stockPrice = price;
    }

    public Manifest.Currency getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(Manifest.Currency currency) {
        this.tradeCurrency = currency;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
