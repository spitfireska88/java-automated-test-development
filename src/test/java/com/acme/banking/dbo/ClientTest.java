package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


import java.util.UUID;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ClientTest {
//    Client sut;
    UUID stubId;
    String name;
    Client sut;
    @Before
    public void initSut(){
        stubId = UUID.randomUUID();
        name = "dummy client name";
        sut = new Client(stubId,name);
    }
    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        //endregion

        //region when
        //endregion

        //region then
        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
        assertThat(sut.getName(),
                allOf(
                        equalTo(name),
                        notNullValue()
                ));
        //endregion

    }
    @Test
    public void shouldThrowExceptionWhenAddNullId() {

        Exception e = null;
        try {
            Client sut = new Client (null,name);
        }catch (Exception ex){
          e = ex;
        }
    assertTrue(e instanceof IllegalArgumentException);
    }

    @Test
    public void shouldThrowExceptionWhenAddNullName() {

        Exception e = null;
        try {
            Client sut = new Client (stubId,null);
        }catch (Exception ex){
            e = ex;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }
    @After
    public void deleteSut(){
        stubId = null;
        name = null;
        sut = null;
    }

}
