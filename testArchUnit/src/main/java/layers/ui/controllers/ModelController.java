package layers.ui.controllers;

import thirdpartydependencies.rest.*;

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
