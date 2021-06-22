/*
 * SimpleCalculatorLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */

package io.apimatic.examples.testing;

import io.apimatic.examples.http.client.HttpCallback;
import io.apimatic.examples.http.client.HttpContext;
import io.apimatic.examples.http.request.HttpRequest;
import io.apimatic.examples.http.response.HttpResponse;

/**
 * An HTTPCallback that captures the request and response for use later.
 */
public class HttpCallbackCatcher implements HttpCallback {

    private HttpRequest request;
    private HttpResponse response;
    
    /**
     * Call back executed before the HTTP request is sent.
     */
    public void onBeforeRequest(HttpRequest request) {
        // Nothing to do here
    }

    /**
     * Call back executed after the HTTP response is received
     * but before the APICallback's handler is called.
     */
    public void onAfterResponse(HttpContext context) {
        setRequest(context.getRequest());
        setResponse(context.getResponse());
    }

    /**
     * Get the HTTP Request object associated with this API call.
     * @return the HTTP Request
     */
    public HttpRequest getRequest() {
        return request;
    }

    /**
     * Set the HTTP Request object associated with this API call.
     * @param request the HTTP Request
     */
    private void setRequest(HttpRequest prequest) {
        this.request = prequest;
    }

    /**
     * Get the HTTP Response object associated with this API call.
     * @return the HTTP Response
     */
    public HttpResponse getResponse() {
        return response;
    }

    /**
     * Get the HTTP Response object associated with this API call.
     * @param httpResponse the HTTP Response
     */
    private void setResponse(HttpResponse httpResponse) {
        this.response = httpResponse;
    }
}
