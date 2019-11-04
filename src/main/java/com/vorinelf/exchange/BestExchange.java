package com.vorinelf.exchange;

import com.vorinelf.exchange.currency.Currency;
import com.vorinelf.exchange.currency.UsdCurrency;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class BestExchange {

    public static void main(String[] args) throws IOException {
        ArrayList<Currency> resultExchangeList = new ArrayList<>();

        Document htmlFromSite = Jsoup.connect("https://kurs.onliner.by").get();

        Elements elementsP = htmlFromSite.getElementsByAttributeValue("class", "value fall");

        String elementUsdBankSell = elementsP.get(0).text();
        String elementUsdBankBuy = elementsP.get(1).text();

        resultExchangeList.add(new UsdCurrency(elementUsdBankSell, elementUsdBankBuy));

        System.out.println(resultExchangeList);
    }
}
