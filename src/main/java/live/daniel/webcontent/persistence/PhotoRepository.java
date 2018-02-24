package live.daniel.webcontent.persistence;

import live.daniel.webcontent.model.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Daniel on 29.09.2017.
 */
public interface PhotoRepository extends CrudRepository<Photo, Long> {
    List<Photo> findAllByLink(String link);
}
