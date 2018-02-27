package live.daniel.webcontent.persistence;

import live.daniel.webcontent.model.Video;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Daniel on 29.09.2017.
 */
public interface VideoRepository extends CrudRepository<Video, Long> {
    List<Video> findAllByName(String name);
}
