import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;

public class OAuth {

    public static void run() {
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "client_id=fe11a526-0d48-4adf-9129-4aed22098f8e&grant_type=client_credentials&client_secret=0.zr%3A%2BUmK%5BiEgR2bj5nGTnx3o3%3Fi6xat&resource=51c22b8c-386e-44e8-bc6c-f2c2e9be9ac9");
            Request request = new Request.Builder()
                    .url("https://login.microsoftonline.com/f10f91e5-f905-48aa-8c4c-a68d0ae5f6ec/oauth2/token")
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();

            ObjectMapper mapper = new ObjectMapper();
            if (!response.isSuccessful())
                throw new RuntimeException("Unexpected code " + response);

            JsonNode tree = mapper.readTree(response.body().string());
            String token = tree.path("access_token").asText();
            System.out.println(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
