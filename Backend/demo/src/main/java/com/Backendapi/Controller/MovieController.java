package com.Backendapi.Controller;


import com.Backendapi.Model.ApiEntity;
import com.Backendapi.Model.AverageEntity;
import com.Backendapi.Services.ApiServices;
import com.Backendapi.Services.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/anime")
public class MovieController {

    @Autowired
    private ApiServices apiServices;

    @Autowired
    public MovieController(ApiServices apiServices) {
        this.apiServices = apiServices;
    }

    @GetMapping("/getAll")
    public List<ApiEntity> getAllMovieData() {
        return apiServices.getAllMovieData();
    }

    @GetMapping("/byTitle")
    public List<ApiEntity> getMoviesByTitle(String name) {
           return apiServices.getMoviesByTitle(name);
    }

    @GetMapping("/getAverageScore")
    public AverageEntity getAverageScore() {
        return apiServices.getAverageScore();
    }
}
