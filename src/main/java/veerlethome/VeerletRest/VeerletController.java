package veerlethome.VeerletRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class VeerletController {
    @Autowired
    private VeerletService service;

    @PostMapping("save")
    public void save(@RequestBody VeerletHomeModel veerletHomeModel){

        service.save(veerletHomeModel);
    }

    @GetMapping("/list")
    public List<VeerletHomeModel> list(){
        return service.listAll();

    }
    @GetMapping("{id}")
    public VeerletHomeModel get(@PathVariable Integer id) {

        return  service.get(id);
    }

}
