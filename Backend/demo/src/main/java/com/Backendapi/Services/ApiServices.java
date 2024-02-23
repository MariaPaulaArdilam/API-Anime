package com.Backendapi.Services;

import com.Backendapi.Model.ApiEntity;
import com.Backendapi.Model.AverageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.lang.model.element.Element;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiServices {

    public List<ApiEntity> getAllMovieData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.jikan.moe/v4/anime";
        ResponseData responseData = restTemplate.getForObject(url, ResponseData.class);

        List<ApiEntity> apiEntities = new ArrayList<>();

        if (responseData != null && responseData.getData() != null) {
            for (ResponseData.Movie movie : responseData.getData()) {
                ApiEntity apiEntity = new ApiEntity();
                apiEntity.setTitle(movie.getTitle());
                apiEntity.setImage(movie.getImages().getJpg().getImage_url());
                apiEntity.setScore(movie.getScore());
                apiEntities.add(apiEntity);
            }
        }

        return apiEntities;
    }

    public List<ApiEntity> getMoviesByTitle (String name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.jikan.moe/v4/anime?q="+name;
        ResponseData responseData = restTemplate.getForObject(url, ResponseData.class);

        List<ApiEntity> apiEntities = new ArrayList<>();

        if (responseData != null && responseData.getData() != null) {
            for (ResponseData.Movie movie : responseData.getData()) {
                ApiEntity apiEntity = new ApiEntity();
                apiEntity.setTitle(movie.getTitle());
                apiEntity.setImage(movie.getImages().getJpg().getImage_url());
                apiEntity.setScore(movie.getScore());
                apiEntities.add(apiEntity);
            }
        }

        return apiEntities;
    }

    public AverageEntity getAverageScore () {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.jikan.moe/v4/anime";
        ResponseData responseData = restTemplate.getForObject(url, ResponseData.class);

        ApiEntity apiEntity = new ApiEntity();
        double averageScore = 0;
        int counter = 1;

        if (responseData != null && responseData.getData() != null) {
            for (ResponseData.Movie movie : responseData.getData()) {
                apiEntity.setScore(movie.getScore());
                averageScore = (averageScore + apiEntity.getScore());
                counter++;
            }
        }

        AverageEntity averageEntity = new AverageEntity();

        averageScore = averageScore/counter;
        averageEntity.setAverageScore(averageScore);

        return averageEntity;
    }

}
