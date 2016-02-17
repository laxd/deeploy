package uk.laxd.deepweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.dao.BuildFlowDao;
import uk.laxd.deepweb.model.BuildFlow;

import java.util.List;

/**
 * Created by lawrence on 16/02/16.
 */
@Service
public class BuildFlowServiceImpl implements BuildFlowService {

    @Autowired
    private BuildFlowDao buildFlowDao;

    public List<BuildFlow> findAll() {
        return buildFlowDao.findAll();
    }
}
