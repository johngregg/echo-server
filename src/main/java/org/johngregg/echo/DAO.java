package org.johngregg.echo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DAO {

    @GET("/echo")
    public Call<ResponseBody> echo(@Query("size") int size);
}
