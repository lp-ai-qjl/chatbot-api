package cn.bugstack.chabot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ApiTest {

    @Test
    public void query_unanswered_questions(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51111118445884/topics?scope=all&count=20");
        get.addHeader("cookie","sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218e23bb9b61581-0e563f11c4dd18-26001951-1881600-18e23bb9b62519%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlMjNiYjliNjE1ODEtMGU1NjNmMTFjNGRkMTgtMjYwMDE5NTEtMTg4MTYwMC0xOGUyM2JiOWI2MjUxOSJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218e23bb9b61581-0e563f11c4dd18-26001951-1881600-18e23bb9b62519%22%7D; zsxq_access_token=83734101-B6A6-79CA-9966-F9DCAF348EFD_8C56F05FBB3D0C69; zsxqsessionid=e4cf3b313c25f1718567b286ef70a0f1; abtest_env=product");
        get.addHeader("Content-Type","application/json; charset=UTF-8");

        try {
            CloseableHttpResponse response = httpClient.execute(get);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String s = EntityUtils.toString(response.getEntity());
                System.out.println(s);
            }else {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void answer() throws UnsupportedEncodingException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/1522544848154882/comments");
        post.addHeader("cookie","sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218e23bb9b61581-0e563f11c4dd18-26001951-1881600-18e23bb9b62519%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlMjNiYjliNjE1ODEtMGU1NjNmMTFjNGRkMTgtMjYwMDE5NTEtMTg4MTYwMC0xOGUyM2JiOWI2MjUxOSJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218e23bb9b61581-0e563f11c4dd18-26001951-1881600-18e23bb9b62519%22%7D; zsxq_access_token=83734101-B6A6-79CA-9966-F9DCAF348EFD_8C56F05FBB3D0C69; zsxqsessionid=e4cf3b313c25f1718567b286ef70a0f1; abtest_env=product");
        post.addHeader("Content-Type","application/json; charset=UTF-8");

        String paramJson="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"可以去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson,  "UTF-8");
        post.setEntity(stringEntity);

        try {
            CloseableHttpResponse response = httpClient.execute(post);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String s = EntityUtils.toString(response.getEntity());
                System.out.println(s);
            }else {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
