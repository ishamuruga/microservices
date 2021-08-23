package com.superstar.retail.account.api;

import com.superstar.retail.account.dto.CreateAccountDTORequest;
import com.superstar.retail.account.dto.CreateAccountDTOResponse;
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
}
