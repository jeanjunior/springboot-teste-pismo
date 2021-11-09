package com.heldt.pismo.springboottestepismo.core.model;

import java.util.HashMap;
import java.util.Map;

public enum OperationType {

    COMPRA_A_VISTA(1),
    COMPRA_PARCELADA(2),
    SAQUE(3),
    PAGAMENTO(4);

    private final int value;
    private static final Map<Integer, OperationType> map = new HashMap<>();

    static {
        for (OperationType pageType : OperationType.values()) {
            map.put(pageType.value, pageType);
        }
    }

    OperationType(int value) {
        this.value = value;
    }

    public static OperationType valueOf(Integer value) {
        return value != null && map.containsKey(value) ? map.get(value) : null;
    }

    public int getValue() {
        return value;
    }

}
