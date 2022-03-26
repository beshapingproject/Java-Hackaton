package it.be.codingRace.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class JsonResponseBody {

        public JsonResponseBody() {
            super();
        }
        @Getter
        @Setter
        private int server;
        @Getter @Setter
        private Object response;
    }
