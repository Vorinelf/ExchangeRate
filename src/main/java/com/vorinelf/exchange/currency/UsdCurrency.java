package com.vorinelf.exchange.currency;

public class UsdCurrency extends Currency {


    public UsdCurrency(String bankSell, String bankBuy) {
        super(bankSell, bankBuy);
    }

    @Override
    public String toString() {
        return "UsdCurrency{" +
                "bankSell='" + super.getBankSell() + '\'' +
                ", bankBuy='" + super.getBankBuy() + '\'' +
                '}';
    }
}
