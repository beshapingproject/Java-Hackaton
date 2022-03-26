package it.be.codingRace.validation;

import it.be.codingRace.entity.Utente;
import it.be.codingRace.exception.UserException;
import it.be.codingRace.utils.Constants;

import javax.servlet.http.HttpServletRequest;

public class UserSession {

    public static Utente checkUtenteInSession(HttpServletRequest request) {

        Utente utente = null;
        try {
            utente = (Utente) request.getSession().getAttribute(Constants.UTENTE_SESSION.getValue());
            if (utente == null) {
                return null;
            }
        } catch(Exception e) {
            throw new UserException("Sessione utente scaduta!");
        }

        return utente;
    }


}
