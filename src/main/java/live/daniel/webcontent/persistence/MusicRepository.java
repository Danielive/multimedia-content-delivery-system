package live.daniel.webcontent.persistence;

import live.daniel.webcontent.model.Music;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Daniel on 29.09.2017.
 */
public interface MusicRepository extends CrudRepository<Music, Long> {
    List<Music> findAllByName(String name);
}
