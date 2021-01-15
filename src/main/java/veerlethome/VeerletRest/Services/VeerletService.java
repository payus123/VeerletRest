package veerlethome.VeerletRest.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veerlethome.VeerletRest.Models.VeerletHomeModel;
import veerlethome.VeerletRest.Repositories.VeerletHomeRepository;

import java.util.List;


@Service
public class VeerletService {
    @Autowired
    public VeerletHomeRepository repo;

    public void save(VeerletHomeModel veerletHomeModel){
        repo.save(veerletHomeModel);



    }
    public List<VeerletHomeModel> listAll(){
        return repo.findAll();


    }
    public VeerletHomeModel get(Integer id){
        return  repo.findById(id).get();
    }

 public VeerletHomeModel jsoOject(VeerletHomeModel veerletHomeModel){

        return repo.findByUserName(veerletHomeModel.getUsername());

}


}
