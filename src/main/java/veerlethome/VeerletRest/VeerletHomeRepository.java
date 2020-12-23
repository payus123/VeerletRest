package veerlethome.VeerletRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

public interface VeerletHomeRepository extends JpaRepository<VeerletHomeModel,Integer> {

    @Query("SELECT u FROM VeerletHomeModel u WHERE u.username = :username")
     VeerletHomeModel findByUserName  (@Param("username") String username);

}

