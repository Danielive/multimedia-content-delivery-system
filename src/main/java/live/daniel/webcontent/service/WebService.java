package live.daniel.webcontent.service;

import live.daniel.webcontent.persistence.MusicRepository;
import live.daniel.webcontent.persistence.PhotoRepository;
import live.daniel.webcontent.persistence.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Daniel on 29.09.2017.
 */
@Service
public class WebService {
    private final PhotoRepository pRepository;
    private final MusicRepository mRepository;
    private final VideoRepository vRepository;

    @Autowired
    public WebService(MusicRepository mRepository, PhotoRepository pRepository, VideoRepository vRepository) {
        this.mRepository = mRepository;
        this.pRepository = pRepository;
        this.vRepository = vRepository;
    }

    public String findAllPhoto() {
        return pRepository.findAll().toString();
    }
    public String findAllNamePhoto(String name) {
        return pRepository.findAllByName(name).toString();
    }

    public String findAllMusic() {
        return mRepository.findAll().toString();
    }
    public String findAllNameMusic(String name) {
        return mRepository.findAllByName(name).toString();
    }

    public String findAllVideo() {
        return vRepository.findAll().toString();
    }
    public String findAllNameVideo(String name) {
        return vRepository.findAllByName(name).toString();
    }
}