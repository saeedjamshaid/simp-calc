/*
 * SimpleCalculatorLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */

package io.apimatic.examples.controllers;

import io.apimatic.examples.ApiHelper;
import io.apimatic.examples.AuthManager;
import io.apimatic.examples.Configuration;
import io.apimatic.examples.exceptions.ApiException;
import io.apimatic.examples.http.Headers;
import io.apimatic.examples.http.client.HttpClient;
import io.apimatic.examples.http.client.HttpContext;
import io.apimatic.examples.http.request.HttpRequest;
import io.apimatic.examples.http.response.HttpResponse;
import io.apimatic.examples.http.response.HttpStringResponse;
import io.apimatic.examples.models.OperationTypeEnum;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class SimpleCalculatorController extends BaseController {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public SimpleCalculatorController(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }


    /**
     * Calculates the expression using specified operation.
     * @param  operation  Required parameter: The operator to apply on the variables
     * @param  x  Required parameter: This is LHS value
     * @param  y  Required parameter: This is RHS value
     * @return    Returns the Double response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public Double calculate(
            final OperationTypeEnum operation,
            final double x,
            final double y) throws ApiException, IOException {
        HttpRequest request = buildCalculateRequest(operation, x, y);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCalculateResponse(context);
    }

    /**
     * Calculates the expression using specified operation.
     * @param  operation  Required parameter: The operator to apply on the variables
     * @param  x  Required parameter: This is LHS value
     * @param  y  Required parameter: This is RHS value
     * @return    Returns the Double response from the API call
     */
    public CompletableFuture<Double> calculateAsync(
            final OperationTypeEnum operation,
            final double x,
            final double y) {
        return makeHttpCallAsync(() -> buildCalculateRequest(operation, x, y),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCalculateResponse(context));
    }

    /**
     * Builds the HttpRequest object for calculate.
     */
    private HttpRequest buildCalculateRequest(
            final OperationTypeEnum operation,
            final double x,
            final double y) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/{operation}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("operation",
                new SimpleEntry<Object, Boolean>(((operation != null) ? operation.value() : null), true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("x", x);
        queryParameters.put("y", y);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseController.userAgent);

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        return request;
    }

    /**
     * Processes the response for calculate.
     * @return An object of type double
     */
    private Double handleCalculateResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        double result = Double.parseDouble(responseBody);

        return result;
    }

}