package com.Backendapi.Services;

import com.Backendapi.Model.ApiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.lang.model.element.Element;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServices {

    public List<ApiEntity> getAllMovieData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.jikan.moe/v4/anime?q";
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
}
