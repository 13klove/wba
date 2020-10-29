package web.boostcourse.api.wba.config.security.refreshStore;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RefreshStore {

    private Cache<String, String> refreshStore = CacheBuilder.newBuilder().build();

}
