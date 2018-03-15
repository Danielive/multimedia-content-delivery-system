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

import java.util.*;

/**
 * Created by Daniel on 29.09.2017.
 */
@Controller
public class WebController {

    private final WebService service;

    @Autowired
    public WebController(WebService service) {
        this.service = service;
    }

    // Find
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ModelAndView getFindByName(String nameReq) {
        ModelAndView model = new ModelAndView("find");
        List<Photo> pList = new ArrayList<>();
        List<Music> mList = new ArrayList<>();
        List<Video> vList = new ArrayList<>();
        List<Object> list = new ArrayList<>();
        String strJsonP;
        String strJsonM;
        String strJsonV;

        if ((nameReq != null) && (!nameReq.isEmpty())) {
            strJsonP = service.findAllPhoto();
            strJsonM = service.findAllMusic();
            strJsonV = service.findAllVideo();

            strJsonP = finder(strJsonP, nameReq, "photo");
            strJsonM = finder(strJsonM, nameReq, "music");
            strJsonV = finder(strJsonV, nameReq, "video");

            findContent("photo", strJsonP, pList);
            findContent("music", strJsonM, mList);
            findContent("video", strJsonV, vList);
        }

        if (!pList.isEmpty())
            list.addAll(pList);
        if (!mList.isEmpty())
            list.addAll(mList);
        if (!vList.isEmpty())
            list.addAll(vList);

        Map<String,Object> allFiles = new HashMap<>();
        allFiles.put("allFiles", list);

        model.addAllObjects(allFiles);

        return model;
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ModelAndView postFindByName(@RequestParam(value = "name") String name) {
        return getFindByName(name);
    }

    private String finder(String str, String reqStr, String type) {
        Map<String, Object> mapContent;
        String valueJson;
        String contentJson = "";
        int sizeBuf;
        boolean find;

        String strJson = str;

        strJson = strJson.replace("[", "");
        strJson = strJson.replace("]", "");
        strJson = strJson.replace("\"}, ", "\"},");
        strJson = strJson.concat(" ");

        while (!strJson.isEmpty()) {
            JSONObject jsonObject = new JSONObject(strJson);
            mapContent = jsonToMap(jsonObject);
            valueJson = JSONObject.valueToString(mapContent);
            sizeBuf = valueJson.length();
            find = false;

            if (reqStr == null) reqStr = "";

            for (Map.Entry entry : mapContent.entrySet()) {
                if (entry.getKey().equals("name"))
                    if (findInString(entry.getValue().toString(), reqStr))
                        find = true;
            }

            if (find) {
                if (!contentJson.equals("")) contentJson = contentJson.concat(",");
                contentJson = contentJson.concat(valueJson);
            }

            strJson = strJson.substring(sizeBuf + 1);
        }

        contentJson = "[" + contentJson + "]";
        contentJson = contentJson.replace("[", "{\"" + type + "\":[");
        contentJson = contentJson.replace("]", "]}");

        return contentJson;
    }

    private void findContent(String content, String strJson, List list) {
        try {
            JSONObject dataJsonObj = new JSONObject(strJson);
            JSONArray photo = dataJsonObj.getJSONArray(content);
            String link;
            String name;
            Long id;
            String type;

            for (int i = 0; i < photo.length(); i++) {
                JSONObject getPhotos = photo.getJSONObject(i);
                id = getPhotos.getLong("id");
                name = getPhotos.getString("name");
                link = getPhotos.getString("link");
                type = getPhotos.getString("type");
                list.add(new Photo(id, name, link, type));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
        Map<String, Object> retMap = new HashMap<>();

        if(json != JSONObject.NULL) {
            retMap = toMap(json);
        }
        return retMap;
    }

    private static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    private static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }

    private boolean findInString(String str, String strIn) {
        str = str.toLowerCase();
        strIn = strIn.toLowerCase();
        return str.matches("(.*)" + strIn + "(.*)");
    }

    // Photos
    @RequestMapping(value = "/photo", method = RequestMethod.GET)
    public ModelAndView getPhotos() {
        ModelAndView model = new ModelAndView("photo");
        List<Photo> list = new ArrayList<>();
        String strJson = service.findAllPhoto();

        strJson = strJson.replace("[", "{\"photo\":[");
        strJson = strJson.replace("]", "]}");

        findContent("photo", strJson, list);

        Map<String,Object> allPhoto = new HashMap<>();
        allPhoto.put("allPhoto", list);
        model.addAllObjects(allPhoto);

        return model;
    }

    // Music
    @RequestMapping(value = "/music", method = RequestMethod.GET)
    public ModelAndView getMusic() {
        ModelAndView model = new ModelAndView("music");
        List<Music> list = new ArrayList<>();
        String strJson = service.findAllMusic();

        strJson = strJson.replace("[", "{\"music\":[");
        strJson = strJson.replace("]", "]}");

        findContent("music", strJson, list);

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

        strJson = strJson.replace("[", "{\"video\":[");
        strJson = strJson.replace("]", "]}");

        findContent("video", strJson, list);

        Map<String,Object> allVideo = new HashMap<>();
        allVideo.put("allVideo", list);
        model.addAllObjects(allVideo);

        return model;
    }
}
