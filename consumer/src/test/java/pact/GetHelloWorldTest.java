package pact;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.model.PactFragment;
import org.junit.Rule;
import org.junit.Test;
import utils.Configuration;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetHelloWorldTest
{
    @Rule
    public PactRule rule = new PactRule(Configuration.MOCK_HOST, Configuration.MOCK_HOST_PORT, this);
    private DslPart helloWorldResults;

    @Pact(state = "HELLO WORLD", provider = Configuration.DUMMY_PROVIDER, consumer = Configuration.DUMMY_CONSUMER)
    public PactFragment createFragment(ConsumerPactBuilder.PactDslWithProvider.PactDslWithState builder)
    {
        helloWorldResults = new PactDslJsonBody()
                .id()
                .stringType("content")
                .asBody();

        return builder
                .uponReceiving("get hello world response")
                .path("/hello-world")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(Configuration.getHeaders())
                .body(helloWorldResults)
                .toFragment();
    }

    @Test
    @PactVerification("HELLO WORLD")
    public void shouldGetHelloWorld() throws IOException
    {
        DummyConsumer restClient = new DummyConsumer(Configuration.SERVICE_URL);
        assertEquals(helloWorldResults.toString(), restClient.getHelloWorld());
    }
}
