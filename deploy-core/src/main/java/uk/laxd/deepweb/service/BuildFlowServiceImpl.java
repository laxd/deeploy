package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.lang.NotFoundException;
import uk.laxd.deepweb.model.BuildFlow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lawrence on 16/02/16.
 */
@Service
public class BuildFlowServiceImpl implements BuildFlowService {

	@Autowired
	private Dao<BuildFlow, Long> buildFlowDao;

	@Override
	public BuildFlow findById(Long id) throws NotFoundException {
		try {
			return buildFlowDao.queryForId(id);
		} catch (SQLException e) {
			throw new NotFoundException(e);
		}
	}

	@Override
	public List<BuildFlow> findAll() {
		try {
			return buildFlowDao.queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public void create(BuildFlow buildFlow) {
		try {
			buildFlowDao.create(buildFlow);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
