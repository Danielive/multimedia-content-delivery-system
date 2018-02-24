package live.daniel.webcontent.service;

import live.daniel.webcontent.model.Music;
import live.daniel.webcontent.persistence.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Daniel on 29.09.2017.
 */
@Service
public class WebService {
    @Autowired
    private MusicRepository mRepository;

    public String findAll() {
        return mRepository.findAll().toString();
    }

    public List<Music> findAllLink(String link) {
        return mRepository.findAllByLink(link);
    }

    public void addSite(String name, String link) {
        mRepository.save(new Music(name, link));
    }

    public void delSite(Long id) {
        mRepository.delete(id);
    }
}