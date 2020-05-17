package com.acme.banking.dbo;
import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


import java.util.UUID;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SavingAccountTest {
    private double amount;
    private UUID id;
    private String clientName;
    private Client client;
    private SavingAccount sut;
    private UUID stubId;
    @Before
    public void initSut(){
        stubId = UUID.randomUUID();
        clientName = "dummy client name";
        client = new Client(stubId,clientName);
        id = UUID.randomUUID();
        amount = 10.5;
        sut = new SavingAccount(id,client,amount );

    }

    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region then
        assertThat(sut.getId(),
                allOf(
                        equalTo(id),
                        notNullValue()
                ));
        assertThat(sut.getClientId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
        assertThat(sut.getAmount(),
                allOf(
                        equalTo(amount),
                        notNullValue()
                ));
        assertThat(sut.getClient(),
                allOf(
                        equalTo(client),
                        notNullValue()
                ));
        //endregion

    }
    @Test
    public  void shouldThrowExceptionWhenAddNullClient(){

        Exception e = new Exception();
        try{
            SavingAccount sut = new SavingAccount(id,null,amount);
        }catch (Exception ex){
            e = ex;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }

    @Test
    public  void shouldThrowExceptionWhenAddNullId(){

        Exception e = new Exception();
        try{
            SavingAccount sut = new SavingAccount(null,client,amount);
        }catch (Exception ex){
            e = ex;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }

    @Test
    public  void shouldThrowExceptionWhenAddZeroAmount(){

        Exception e = new Exception();
        try{
            SavingAccount sut = new SavingAccount(id,client,0.0);
        }catch (Exception ex){
            e = ex;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }
    @After
    public void clearSut(){
        client = null;
        amount = 0.0;
        id = null;
    }
}
