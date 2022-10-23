package com.qaprosoft.carina.demo.testapi;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.testapi.*;
import org.testng.annotations.Test;

public class APITests implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "bozhok")
    public void testCreatePost() throws Exception {
        PostMethod api = new PostMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "bozhok")
    public void testUpdatePost() throws Exception {
        PutMethod api = new PutMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "bozhok")
    public void testGetDog() {
        GetDogMethod getMethod = new GetDogMethod();
        getMethod.callAPIExpectSuccess();
        getMethod.validateResponseAgainstSchema("api/testapi/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "bozhok")
    public void testDeleteUsers() {
        DeleteMethod deleteMethod = new DeleteMethod();
        deleteMethod.callAPIExpectSuccess();
        deleteMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "bozhok")
    public void testGet() {
        GetMethod getMethod = new GetMethod();
        getMethod.callAPIExpectSuccess();
        getMethod.validateResponseAgainstSchema("api/testapi/_get1/rs.schema");
    }
}
