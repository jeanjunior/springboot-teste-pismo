package com.heldt.pismo.springboottestepismo.infra.http.controller;

import com.heldt.pismo.springboottestepismo.infra.dto.TransactionDTO;
import com.heldt.pismo.springboottestepismo.infra.dto.TransactionPostDTO;
import com.heldt.pismo.springboottestepismo.core.port.TransactionDtoMapper;
import com.heldt.pismo.springboottestepismo.core.model.Transaction;
import com.heldt.pismo.springboottestepismo.core.port.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@Api(value = "API para informações de Transações",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TransactionController {

    private TransactionService service;
    private TransactionDtoMapper mapper;

    @PostMapping
    @ApiOperation(value = "Criação de uma transação")
    public ResponseEntity<TransactionDTO> save(@RequestBody TransactionPostDTO transaction) {
        Transaction model = service.save(mapper.toModel(transaction));
        TransactionDTO dto = mapper.toDto(model);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}
