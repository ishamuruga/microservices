package com.superstar.retail.account.service;

import com.superstar.retail.account.entity.Account;
import com.superstar.retail.account.exception.InSufficientBalance;

public interface AccountManager {
    public Account createAccount(Account acct);

    public Account disableAccount(Account act);

    public Account enableAccount(Account act);

    public Account creditAccount(Account act, Double balance);

    public Account debitAccount(Account act, Double balance) throws InSufficientBalance;

}
