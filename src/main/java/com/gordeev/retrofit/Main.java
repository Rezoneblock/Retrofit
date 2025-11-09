package com.gordeev.retrofit;

import com.gordeev.retrofit.request.PostCreateRequest;
import com.gordeev.retrofit.request.PostUpdateRequest;
import com.gordeev.retrofit.response.PostResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        // Получение всех элементов, или выборочно через указание id в api.posts({id})
        JsonPlaceholderAPI api = JsonPlaceholderService.getInstance().api();
        Response<List<PostResponse>> postResponses = api.posts(null).execute();

        List<PostResponse> posts = postResponses.body();
//        System.out.println(posts);

        // Создание элемента
        PostCreateRequest createRequest = new PostCreateRequest();
        createRequest.setBody("create");
        createRequest.setTitle("createTitle");
        createRequest.setUserId(1);
        PostResponse postResponseCreate = api.create(createRequest).execute().body();
//        System.out.println(postResponseCreate);

        // Обновление элемента
        PostUpdateRequest updateRequest = new PostUpdateRequest();
        updateRequest.setBody("update");
        updateRequest.setTitle("updateTitle");
        updateRequest.setUserId(1);
        updateRequest.setId(1);
        PostResponse postResponseUpdate = api.update(1, updateRequest).execute().body();
//        System.out.println(postResponseUpdate);

        // Удаление элемента
        Integer code = api.delete(1).execute().code();
//        System.out.println(code);
    }
}
