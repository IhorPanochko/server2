package com.example.server2.exception;

import com.google.gson.Gson;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
@Order(-2)
class RestWebExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        if (ex instanceof LocationsNotFoundException ) {
            LocationsNotFoundException myException = (LocationsNotFoundException) ex;
            String body = new Gson().toJson(myException.getExceptionInfo());
            exchange.getResponse().getHeaders().add("Content-Type", "application/json");
            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return exchange.getResponse().writeWith(Flux.just(buffer));
        }
        if (ex instanceof UsersNotFoundException ) {
            UsersNotFoundException myException = (UsersNotFoundException) ex;
            String body = new Gson().toJson(myException.getExceptionInfo());
            exchange.getResponse().getHeaders().add("Content-Type", "application/json");
            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return exchange.getResponse().writeWith(Flux.just(buffer));
        }

        return Mono.error(ex);
    }


}

