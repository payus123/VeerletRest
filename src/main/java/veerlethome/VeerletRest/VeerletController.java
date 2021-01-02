package veerlethome.VeerletRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import veerlethome.VeerletRest.Models.AuthModel;
import veerlethome.VeerletRest.Models.VeerletHomeModel;
import veerlethome.VeerletRest.Secuirity.Jwt_util;
import veerlethome.VeerletRest.Services.VeerletService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class VeerletController {
    private String token;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Jwt_util jwt_util;



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

   @PostMapping("/auth")
     public String generateToken(@RequestBody AuthModel authModel) throws Exception{


       try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authModel.getUsername(),authModel.getPassword())
            );
        }catch (Exception exception){
            throw new Exception("Error password");
        }
       String user = authModel.getUsername();
try{
     token= jwt_util.generateToken(user);


}  catch (Exception e) {
    throw new Exception(e);
}
       return token ;
    }


}
