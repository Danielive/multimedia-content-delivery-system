package live.daniel.webcontent.service;

import live.daniel.webcontent.model.Music;
import live.daniel.webcontent.model.Photo;
import live.daniel.webcontent.model.Video;
import live.daniel.webcontent.persistence.MusicRepository;
import live.daniel.webcontent.persistence.PhotoRepository;
import live.daniel.webcontent.persistence.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Daniel on 29.09.2017.
 */
@Service
public class WebService {
    @Autowired
    private PhotoRepository pRepository;
    @Autowired
    private MusicRepository mRepository;
    @Autowired
    private VideoRepository vRepository;

    public String findAllPhoto() {
        return pRepository.findAll().toString();
    }
    public String findAllNamePhoto(String name) {
        return pRepository.findAllByName(name).toString();
    }
    public void addPhoto(String name, String link) {
        pRepository.save(new Photo(name, link));
    }
    public void delPhoto(Long id) {
        pRepository.delete(id);
    }

    public String findAllMusic() {
        return mRepository.findAll().toString();
    }
    public String findAllNameMusic(String name) {
        return mRepository.findAllByName(name).toString();
    }
    public void addMusic(String name, String link) {
        mRepository.save(new Music(name, link));
    }
    public void delMusic(Long id) {
        mRepository.delete(id);
    }

    public String findAllVideo() {
        return vRepository.findAll().toString();
    }
    public String findAllNameVideo(String name) {
        return vRepository.findAllByName(name).toString();
    }
    public void addVideo(String name, String link) {
        vRepository.save(new Video(name, link));
    }
    public void delVideo(Long id) {
        vRepository.delete(id);
    }
}