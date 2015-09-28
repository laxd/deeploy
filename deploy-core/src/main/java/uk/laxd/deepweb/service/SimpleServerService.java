package uk.laxd.deepweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.dao.CredentialsDao;
import uk.laxd.deepweb.dao.ServerDao;
import uk.laxd.deepweb.lang.Constants;
import uk.laxd.deepweb.model.Credentials;
import uk.laxd.deepweb.model.Server;

import java.util.List;

/**
 * Created by Lenny on 20/09/2015.
 */
@Service(Constants.Service.SERVER_SERVICE)
public class SimpleServerService implements ServerService {

    @Autowired
    @Qualifier(Constants.Dao.SERVER_DAO)
    private ServerDao serverDao;

    public List<Server> findAll() {
        return serverDao.findAll();
    }

    public Server findById(int id) {
        return serverDao.findById(id);
    }
}
