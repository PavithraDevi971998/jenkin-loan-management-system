package com.springreactive.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import com.springreactive.handler.CustomerHandler;

import static com.springreactive.constants.Constants.CUSTOMER_FUNCTIONAL_END_POINT_V1;
@Configuration
public class CustomerRouter {
	@Bean
    public RouterFunction<ServerResponse> customerRoute(CustomerHandler customerHandler){

        return RouterFunctions
        		.route(GET(CUSTOMER_FUNCTIONAL_END_POINT_V1).and(accept(MediaType.APPLICATION_JSON))
                        ,customerHandler::getAllItems);
    }
}
