import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by lynn on 2017/12/8.
 */
public class OkHttpTest {
    private static final OkHttpClient client = new OkHttpClient();

//    public void run() throws Exception {
//        Request request = new Request.Builder()
//                .url("http://www.baidu.com")
//                .build();
//
//        Response response = client.newCall(request).execute();
//        if (!response.isSuccessful()) {
//            throw new IOException("Unexpected code " + response);
//        }
//
//        Headers responseHeaders = response.headers();
//        for (int i = 0; i < responseHeaders.size())
//    }

//    public static void main(String[] args) throws Exception{
//        final Request request = new Request.Builder().url("https://github.com").build();
//        Response response = client.newCall(request).execute();
//    }

}
