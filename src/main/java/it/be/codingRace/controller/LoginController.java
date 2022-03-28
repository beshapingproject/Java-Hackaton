/*
package it.be.codingRace.controller;

import it.be.codingRace.entity.Utente;
import it.be.codingRace.exception.UserException;
import it.be.codingRace.utils.Constants;
import it.be.codingRace.utils.JsonResponseBody;
import it.be.codingRace.validation.UserSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("login")
public class LoginController {


    @PostMapping("/do")

    public ResponseEntity<Utente> loginAction(HttpServletRequest request, HttpServletResponse response) {


        Utente utente = new Utente("test", "test");
        request.getSession().setAttribute(Constants.UTENTE_SESSION.getValue(), utente);

        return ResponseEntity.status(HttpStatus.OK).body(utente);


    }


}

*/
