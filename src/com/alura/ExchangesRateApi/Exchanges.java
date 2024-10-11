package com.alura.ExchangesRateApi;

import java.util.Map;

public record Exchanges(String base_code,String target_code,Double conversion_rate,Map<String, Double> conversion_rates) {
    public Exchanges(String base_code, String target_code, Double conversion_rate) {
        this(base_code,target_code,conversion_rate,null);

    }
}


