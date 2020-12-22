package veerlethome.VeerletRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface VeerletHomeRepository extends JpaRepository<VeerletHomeModel,Integer> {

    VeerletHomeModel findByUsername(String username);
}

