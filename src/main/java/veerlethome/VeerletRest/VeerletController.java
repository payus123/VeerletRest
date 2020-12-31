package veerlethome.VeerletRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import veerlethome.VeerletRest.Models.AuthModel;
import veerlethome.VeerletRest.Models.VeerletHomeModel;
import veerlethome.VeerletRest.Secuirity.JWT_UTIL;
import veerlethome.VeerletRest.Services.VeerletService;

import java.util.List;

@RestController
public class VeerletController {

    @Autowired
    private AuthenticationManager authenticationManager;
     @Autowired
    private JWT_UTIL jwt_util ;



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

   @PostMapping("/login")
     public String generateToken(@RequestBody AuthModel authModel) throws Exception{


       try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authModel.getUsername(),authModel.getPassword())
            );
        }catch (Exception exception){
            throw new Exception("Error password");
        }
       String user = authModel.getUsername();

         String token= jwt_util.generateToken(user);
        return token;
     }


}
