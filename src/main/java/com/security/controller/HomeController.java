package com.security.controller;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhiqiang.zhao on 2017/1/16.
 */
@RestController
public class HomeController {


    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE   )
    public Map home(String key) {

        String url = "http://wiki.joyme.com";
        Map result = new HashMap<>();
        try {
            HttpResponse<String> stringHttpResponse = Unirest.get(url+"/ro/%E9%AD%94%E7%89%A9%E5%88%97%E8%A1%A8").asString();
            String html = stringHttpResponse.getBody();
            Document doc = Jsoup.parse(html);
            Elements elements = doc.select(".floatnone");
            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                String href = element.getElementsByAttribute("href").attr("href");
                if (href.endsWith("jpg")) {
                    continue;
                }
                String r = url + href;
                HttpResponse<String> content = Unirest.get(r).asString();
                String contentHtml = content.getBody();
                Document parse = Jsoup.parse(contentHtml);
                Elements e =parse.select("[colspan='3']");
                if (e.get(0).toString().indexOf(key) > 0) {
                    Pattern p_script = Pattern.compile("<([^>]*)>", Pattern.CASE_INSENSITIVE);
                    Matcher m_script = p_script.matcher(e.get(0).toString());
                    result.put(r, m_script.replaceAll(""));
                }
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/mowu", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String test(String name) {
        String url = "http://wiki.joyme.com";
        try {
            HttpResponse<String> stringHttpResponse = Unirest.get(url + "/ro/"+ name).asString();
            String html = stringHttpResponse.getBody();
            Document doc = Jsoup.parse(html);
            Elements e = doc.select("[colspan='3']");
            Pattern p_script = Pattern.compile("<([^>]*)>", Pattern.CASE_INSENSITIVE);
            Matcher m_script = p_script.matcher(e.get(0).toString());
            return m_script.replaceAll(""); // 过滤script标签
        } catch (Exception e) {

        }
        return null;
    }
}
