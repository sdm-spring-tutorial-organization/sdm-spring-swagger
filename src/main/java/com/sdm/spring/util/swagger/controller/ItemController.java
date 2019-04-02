package com.sdm.spring.util.swagger.controller;

import com.sdm.spring.util.swagger.model.Item;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class ItemController {

    @ApiOperation(value = "ApiOperationValue"/*함수이름대체*/, nickname = "ApiOperationNickname"/**/)
    @RequestMapping(value = "/item", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "newA"/*param' name*/, value = "User's a"/*Description*/, required = true/*bold*/, dataType = "string", paramType = "query", defaultValue = "defaultA"/*input-value*/),
            @ApiImplicitParam(name = "newB"/*param' name*/, value = "User's b"/*Description*/, required = false, dataType = "string", paramType = "query", defaultValue = "defaultB"/*input-value*/)
    })
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Success", response = Item.class/*반환모델정보*/),
            /*// default-code 401, 403, 404
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),*/
            @ApiResponse(code = 500, message = "Failure")
    })
    public String getItem(
            @RequestParam(value = "newA", defaultValue = "hello") String a,
            @RequestParam(value = "newB", defaultValue = "world") String b) {
        System.out.println(a);
        System.out.println(b);
        return a + b;
    }

    @RequestMapping(value = "/item/{hello}", method = RequestMethod.GET)
    public String getItemWithQuery(@PathVariable String hello) {
        return hello;
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public String postItem(String a, String b) {
        return a + b;
    }

}
