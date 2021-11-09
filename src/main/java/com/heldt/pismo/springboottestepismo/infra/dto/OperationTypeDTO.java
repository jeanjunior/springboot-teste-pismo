package com.heldt.pismo.springboottestepismo.infra.dto;

import java.util.HashMap;
import java.util.Map;

public enum OperationTypeDTO {

    COMPRA_A_VISTA(1),
    COMPRA_PARCELADA(2),
    SAQUE(3),
    PAGAMENTO(4);

    private final int value;
    private static final Map<Integer, OperationTypeDTO> map = new HashMap<>();

    static {
        for (OperationTypeDTO pageType : OperationTypeDTO.values()) {
            map.put(pageType.value, pageType);
        }
    }

    OperationTypeDTO(int value) {
        this.value = value;
    }

    public static OperationTypeDTO valueOf(int pageType) {
        return (OperationTypeDTO) map.get(pageType);
    }

    public int getValue() {
        return value;
    }

}
