package it.be.codingRace.validation;

import it.be.codingRace.entity.User;
import it.be.codingRace.exception.UserException;
import it.be.codingRace.utils.Constants;

import javax.servlet.http.HttpServletRequest;

public class UserSession {

    public static User checkUtenteInSession(HttpServletRequest request) {

        User user = null;
        try {
            user = (User) request.getSession().getAttribute(Constants.UTENTE_SESSION.getValue());
            if (user == null) {
                return null;
            }
        } catch(Exception e) {
            throw new UserException("Sessione utente scaduta!");
        }

        return user;
    }


}
