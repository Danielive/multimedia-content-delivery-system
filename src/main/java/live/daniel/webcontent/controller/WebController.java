package live.daniel.webcontent.controller;

import live.daniel.webcontent.model.Music;
import live.daniel.webcontent.model.Photo;
import live.daniel.webcontent.model.Video;
import live.daniel.webcontent.service.WebService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Daniel on 29.09.2017.
 */
@Controller
public class WebController {

    @Autowired
    private WebService service;

//    @RequestMapping("/add")
//    public void addSite(@RequestParam("link") String link, @RequestParam("ip") String ip, @RequestParam("date") String date){
//        // service.addSite(link, ip, date);
//    }
//
//    @RequestMapping(value="/deletesite", method = RequestMethod.POST)
//    public String postDelete(@RequestParam String id) {
//        service.delSite(Long.valueOf(id));
//        return "registry";
//    }

    // Music
    @RequestMapping(value = "/music", method = RequestMethod.GET)
    public ModelAndView getMusic() {
        ModelAndView model = new ModelAndView("music");
        List<Music> list = new ArrayList<>();
        String strJson = service.findAllMusic();

        JSONObject dataJsonObj;
        String link;
        String name;
        Long id;

        strJson = strJson.replace("[", "{\"music\":[");
        strJson = strJson.replace("]", "]}");

        try {
            dataJsonObj = new JSONObject(strJson);
            JSONArray music = dataJsonObj.getJSONArray("music");

            for (int i = 0; i < music.length(); i++) {
                JSONObject getMusic = music.getJSONObject(i);
                id = getMusic.getLong("id");
                name = getMusic.getString("name");
                link = getMusic.getString("link");
                list.add(new Music(id, name, link));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Map<String,Object> allMusic = new HashMap<>();
        allMusic.put("allMusic", list);
        model.addAllObjects(allMusic);

        return model;
    }

    // Videos
    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public ModelAndView getVideos() {
        ModelAndView model = new ModelAndView("video");
        List<Video> list = new ArrayList<>();
        String strJson = service.findAllVideo();

        JSONObject dataJsonObj;
        String link;
        String name;
        Long id;

        strJson = strJson.replace("[", "{\"video\":[");
        strJson = strJson.replace("]", "]}");

        try {
            dataJsonObj = new JSONObject(strJson);
            JSONArray video = dataJsonObj.getJSONArray("video");

            for (int i = 0; i < video.length(); i++) {
                JSONObject getVideo = video.getJSONObject(i);
                id = getVideo.getLong("id");
                name = getVideo.getString("name");
                link = getVideo.getString("link");
                list.add(new Video(id, name, link));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Map<String,Object> allVideo = new HashMap<>();
        allVideo.put("allVideo", list);
        model.addAllObjects(allVideo);

        return model;
    }

    // Photos
    @RequestMapping(value = "/photo", method = RequestMethod.GET)
    public ModelAndView getPhotos() {
        ModelAndView model = new ModelAndView("photo");
        List<Photo> list = new ArrayList<>();
        String strJson = service.findAllPhoto();

        JSONObject dataJsonObj;
        String link;
        String name;
        Long id;

        strJson = strJson.replace("[", "{\"photo\":[");
        strJson = strJson.replace("]", "]}");

        try {
            dataJsonObj = new JSONObject(strJson);
            JSONArray photo = dataJsonObj.getJSONArray("photo");

            for (int i = 0; i < photo.length(); i++) {
                JSONObject getPhotos = photo.getJSONObject(i);
                id = getPhotos.getLong("id");
                name = getPhotos.getString("name");
                link = getPhotos.getString("link");
                list.add(new Photo(id, name, link));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Map<String,Object> allPhoto = new HashMap<>();
        allPhoto.put("allPhoto", list);
        model.addAllObjects(allPhoto);

        return model;
    }
}
