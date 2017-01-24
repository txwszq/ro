package com.oberserve;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Created by zhiqiang.zhao on 2017/1/22.
 */
public class Test {

//    public static void main(String[] args) {
//        String key ="星星的角";
//        String url = "http://wiki.joyme.com";
//        List<String> result = new ArrayList<>();
//        try {
//            HttpResponse<String> stringHttpResponse = Unirest.get(url+"/ro/%E9%AD%94%E7%89%A9%E5%88%97%E8%A1%A8").asString();
//            String html = stringHttpResponse.getBody();
//            Document doc = Jsoup.parse(html);
//            Elements elements = doc.select(".floatnone");
//            for (int i = 0; i < elements.size(); i++) {
//                Element element = elements.get(i);
//                String href = element.getElementsByAttribute("href").attr("href");
//                if (href.endsWith("jpg")) {
//                    continue;
//                }
//                String r = url + href;
//                HttpResponse<String> content = Unirest.get(r).asString();
//                String contentHtml = content.getBody();
//                Document parse = Jsoup.parse(contentHtml);
//                Elements e =parse.select("[colspan='3']");
//
//                if (e.get(0).toString().contains(key)) {
//                    System.out.println(r);
//                    result.add(r);
//                }
//            }
//        } catch (UnirestException e) {
//            e.printStackTrace();
//        }
//    }
}
