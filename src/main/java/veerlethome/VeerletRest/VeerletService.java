package veerlethome.VeerletRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeerletService {
    @Autowired
    private VeerletHomeRepository repo;

    public void save(VeerletHomeModel veerletHomeModel){
        repo.save(veerletHomeModel);

    }
    public List<VeerletHomeModel> listAll(){
        return repo.findAll();
    }
    public VeerletHomeModel get(Integer id){
        return  repo.findById(id).get();
    }



}
