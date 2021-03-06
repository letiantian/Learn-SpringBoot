package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting1")
    public BaseResponse greeting1(@RequestBody GreetingRequest request) {
        return BaseResponse.success("", new GreetingResponse(counter.incrementAndGet(), String.format(template, request.getMsg())));
    }

}
