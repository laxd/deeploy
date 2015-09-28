package uk.laxd.deepweb.service;

import uk.laxd.deepweb.model.Server;

import java.util.List;

/**
 * Created by Lenny on 20/09/2015.
 */
public interface ServerService {
    public List<Server> findAll();
    public Server findById(int id);
}
