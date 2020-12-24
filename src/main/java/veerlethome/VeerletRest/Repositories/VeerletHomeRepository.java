package veerlethome.VeerletRest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import veerlethome.VeerletRest.Models.VeerletHomeModel;

public interface VeerletHomeRepository extends JpaRepository<VeerletHomeModel,Integer> {

    @Query("SELECT u FROM VeerletHomeModel u WHERE u.username = :username")
     VeerletHomeModel findByUserName  (@Param("username") String username);

}

