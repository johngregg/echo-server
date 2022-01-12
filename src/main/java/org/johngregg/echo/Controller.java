package org.johngregg.echo;

import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@RestController
public class Controller {

    @Autowired
    private DAO dao;

    @GetMapping("/echo")
    public String echo(int size) {
        char[] response = new char[size];
        for (int i = 0; i < size; i++) {
            response[i] = 'a';
        }
        return new String(response);
    }

    @GetMapping("remote")
    public String remoteEcho(int size) throws IOException {
        Call<ResponseBody> call = dao.echo(size);

        Response<ResponseBody> response = call.execute();

        if (!response.isSuccessful()) {
            return "oh jeez " + response.errorBody();
        } else {
            return "remote " + response.body().string();
        }
    }
}
