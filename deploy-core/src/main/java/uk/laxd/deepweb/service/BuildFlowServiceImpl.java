package uk.laxd.deepweb.service;

import com.j256.ormlite.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.model.BuildFlowStep;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lawrence on 16/02/16.
 */
@Service
public class BuildFlowServiceImpl implements BuildFlowService {

	@Autowired
	private Dao<BuildFlow, Long> buildFlowDao;

	@Override
	public BuildFlow findById(Long id) {
		try {
			return buildFlowDao.queryForId(id);
		} catch(SQLException e){
			e.printStackTrace();
			return null;
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

	@Override
	public void addStep(Long id, String type, Map<String, String> arguments) {

		BuildFlowStep buildFlowStep = new BuildFlowStep();
		buildFlowStep.setExecutorName(type);

		for(String key : arguments.keySet()) {
			String value = arguments.get(key);
			BuildFlowStepArgument buildFlowStepArgument = new BuildFlowStepArgument();
			buildFlowStepArgument.setName(key);
			buildFlowStepArgument.setValue(value);
			buildFlowStepArgument.setBuildFlowStep(buildFlowStep);

			buildFlowStep.getArguments().add(buildFlowStepArgument);
		}

		BuildFlow buildFlow = this.findById(id);

		buildFlow.getBuildFlowSteps().add(buildFlowStep);

		try {
			buildFlowDao.update(buildFlow);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
