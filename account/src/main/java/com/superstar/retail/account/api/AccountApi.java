package com.superstar.retail.account.api;

import java.util.UUID;

import com.superstar.retail.account.dto.CreateAccountDTORequest;
import com.superstar.retail.account.dto.CreateAccountDTOResponse;
import com.superstar.retail.account.dto.CreditDebitAccountRequest;
import com.superstar.retail.account.dto.CreditDebitAccountResponse;
import com.superstar.retail.account.entity.Account;
import com.superstar.retail.account.service.AccountManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AccountApi {

    @Autowired
    private AccountManager service;
    
    @PostMapping(value = "/account",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateAccountDTOResponse> createAccount(@RequestBody CreateAccountDTORequest req){
        Account act = req.getAct();

        act = service.createAccount(act);

        CreateAccountDTOResponse res = new CreateAccountDTOResponse();
        res.setActId(act.getAccNbr());
        res.setStatus(true);
        
        return new ResponseEntity<CreateAccountDTOResponse>(res,HttpStatus.OK);

    }

    @PostMapping(value = "/credit",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditDebitAccountResponse> creditAccount(@RequestBody CreditDebitAccountRequest req) throws IllegalAccessException{
        

        System.out.println("---------------" + req.toString());

        Account act = service.creditAccount(req.getAct(),req.getAmount());
        

        CreditDebitAccountResponse res = new CreditDebitAccountResponse();
        res.setAct(act);
        res.setStatus(true);
        res.setTxnRefNumber(UUID.randomUUID().toString());

        return new ResponseEntity<CreditDebitAccountResponse>(res,HttpStatus.OK);

    }
}
