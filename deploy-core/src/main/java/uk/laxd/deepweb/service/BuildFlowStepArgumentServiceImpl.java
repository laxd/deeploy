package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lawrence on 24/02/16.
 */
@Service
public class BuildFlowStepArgumentServiceImpl implements BuildFlowStepArgumentService {

	@Autowired
	private Dao<BuildFlowStepArgument, Long> buildFlowStepArgumentDao;

	@Override
	public BuildFlowStepArgument findById(Long id) {
		try {
			return buildFlowStepArgumentDao.queryForId(id);
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
