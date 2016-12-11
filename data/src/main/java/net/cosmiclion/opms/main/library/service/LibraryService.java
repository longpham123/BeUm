package net.cosmiclion.opms.main.library.service;

import net.cosmiclion.opms.login.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by longpham on 12/10/2016.
 */

public interface LibraryService {
    @GET("api/bookshelves")
    Call<ResponseData> getBooksLibrary(@Header("Authorization") String token);

}
