//package dockerTest;
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.elasticsearch.core.IndexRequest;
//import co.elastic.clients.json.jackson.JacksonJsonpMapper;
//import co.elastic.clients.transport.rest_client.RestClientTransport;
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//
//public class SeleniumGridTestNG {
//
//    private WebDriver chromeDriver;
//    private WebDriver firefoxDriver;
//    private ElasticsearchClient elasticsearchClient;
//
//    @BeforeClass
//    public void setup() throws Exception {
//        // Initialize Elasticsearch client
//        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build();
//        RestClientTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
//        elasticsearchClient = new ElasticsearchClient(transport);
//
//        // Setup Selenium remote drivers for Chrome and Firefox
//        chromeDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
//        firefoxDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new FirefoxOptions());
//    }
//
//    @Test
//    public void testOnChrome() {
//        try {
//            chromeDriver.get("https://www.example.com");
//            String title = chromeDriver.getTitle();
//            Assert.assertTrue(title.contains("Example Domain"), "Title did not match for Chrome.");
//
//            // Log test result as PASS
//            logTestResult("Chrome", "PASS", title);
//        } catch (Exception e) {
//            logTestResult("Chrome", "FAIL", e.getMessage());
//            Assert.fail("Test failed on Chrome: " + e.getMessage());
//        }
//    }
//
//    @Test
//    public void testOnFirefox() {
//        try {
//            firefoxDriver.get("https://www.example.com");
//            String title = firefoxDriver.getTitle();
//            Assert.assertTrue(title.contains("Example Domain"), "Title did not match for Firefox.");
//
//            // Log test result as PASS
//            logTestResult("Firefox", "PASS", title);
//        } catch (Exception e) {
//            logTestResult("Firefox", "FAIL", e.getMessage());
//            Assert.fail("Test failed on Firefox: " + e.getMessage());
//        }
//    }
//
//    @AfterClass
//    public void teardown() {
//        if (chromeDriver != null) {
//            chromeDriver.quit();
//        }
//        if (firefoxDriver != null) {
//            firefoxDriver.quit();
//        }
//    }
//
//    private void logTestResult(String browser, String status, String details) {
//        try {
//            Map<String, Object> jsonMap = new HashMap<>();
//            jsonMap.put("browser", browser);
//            jsonMap.put("status", status);
//            jsonMap.put("details", details);
//            jsonMap.put("timestamp", System.currentTimeMillis());
//
//            IndexRequest<Map<String, Object>> request = IndexRequest.of(i -> i
//                    .index("test-execution-results")
//                    .document(jsonMap)
//            );
//
//            elasticsearchClient.index(request);
//            System.out.println("Logged result: " + jsonMap);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
