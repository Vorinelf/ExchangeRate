package com.vorinelf.exchange.currency;

public class Currency {

    private String bankSell;
    private String bankBuy;

    public Currency(String bankSell, String bankBuy) {
        this.bankSell = bankSell;
        this.bankBuy = bankBuy;
    }

    public String getBankSell() {
        return bankSell;
    }

    public void setBankSell(String bankSell) {
        this.bankSell = bankSell;
    }

    public String getBankBuy() {
        return bankBuy;
    }

    public void setBankBuy(String bankBuy) {
        this.bankBuy = bankBuy;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "bankSell='" + bankSell + '\'' +
                ", bankBuy='" + bankBuy + '\'' +
                '}';
    }
}

