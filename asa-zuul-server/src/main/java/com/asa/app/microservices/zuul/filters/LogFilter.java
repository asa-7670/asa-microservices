package com.asa.app.microservices.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    /*
        déterminer le type de filtre à appliquer:
        - pre : permet d'exécuter du code avant la redirection de la requête vers sa destination finale.
        - post : permet d'exécuter du code après que la requête a été redirigée.
        - route : permet d'agir sur la façon de rediriger les requêtes.
        - error : permet d'agir en cas d'erreur lors de la redirection de la requête.
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /*
        détermine l'ordre d'exécution de ce filtre
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /*
        permet d'écrire les conditions qui doivent être remplies pour que le filtre s'exécute
     */
    @Override
    public boolean shouldFilter() {
        return Boolean.TRUE;
    }
    /*
        la logique du filtre.
    */
    @Override
    public Object run() throws ZuulException {
        HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
        logger.info(">>> Request uri : {} " , req.getRequestURL());
        return null;
    }
}
