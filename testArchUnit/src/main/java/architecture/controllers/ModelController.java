package architecture.controllers;

import thirdpartydependencies.rest.*;
import thirdpartydependencies.rest.swagger.Operation;
import thirdpartydependencies.rest.swagger.Tag;

@RestController
@Tag
public class ModelController {

    @Operation
    @GetMapping
    public Object get() {
        return null;
    }

    @Operation
    @PostMapping
    public String post(String something) {
        return "";
    }

    @Operation
    @PutMapping
    public void put(String something) {
    }

    @Operation
    @PatchMapping
    public void patch(String something) {
    }

    @Operation
    @DeleteMapping
    public void delete(Integer something) {
    }

}
