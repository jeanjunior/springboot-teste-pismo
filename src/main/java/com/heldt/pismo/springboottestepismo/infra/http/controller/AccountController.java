package com.heldt.pismo.springboottestepismo.infra.http.controller;

import com.heldt.pismo.springboottestepismo.infra.dto.AccountDTO;
import com.heldt.pismo.springboottestepismo.infra.dto.AccountPostDTO;
import com.heldt.pismo.springboottestepismo.comum.exception.CustomDataNotFoundException;
import com.heldt.pismo.springboottestepismo.core.port.AccountDtoMapper;
import com.heldt.pismo.springboottestepismo.core.model.Account;
import com.heldt.pismo.springboottestepismo.core.port.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@Api(value = "API para informações de Contas",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AccountController {

    private AccountService service;
    private AccountDtoMapper mapper;

    @GetMapping("{accountId}")
    @ApiOperation(value = "Consulta de informações de uma conta")
    public ResponseEntity<AccountDTO> findById(@PathVariable("accountId") Long id) {
        AccountDTO dto = mapper.toDto(service.findById(id).orElseThrow(CustomDataNotFoundException::new));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Criação de uma Conta")
    public ResponseEntity<AccountDTO> save(@RequestBody AccountPostDTO account) {
        Account model = service.save(mapper.toModel(account));
        AccountDTO dto = mapper.toDto(model);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}
