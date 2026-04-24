import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class sayHelloController {
    @GetMapping("/")
    public String SayHello(){
        return "Hello World";
    }
}