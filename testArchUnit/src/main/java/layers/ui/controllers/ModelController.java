package layers.ui.controllers;

import thirdpartydependencies.ui.*;

@RestController
@Tag
public class ModelController {

    @Operation
    @GetMapping
    public Object getSomething() {
        return null;
    }

    @Operation
    @DeleteMapping
    public void deleteSomething(Integer something) {
    }

    @Operation
    @PutMapping
    public void addSomething(String something) {
    }

}
