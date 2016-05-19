package uk.laxd.deepweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.laxd.deepweb.dao.BuildFlowStepArgumentDao;
import uk.laxd.deepweb.model.BuildFlowStepArgument;

/**
 * Created by lawrence on 24/02/16.
 */
@Service
public class BuildFlowStepArgumentServiceImpl implements BuildFlowStepArgumentService {

	@Autowired
	private BuildFlowStepArgumentDao buildFlowStepArgumentDao;

	@Override
	public BuildFlowStepArgument findById(String id) {
		return buildFlowStepArgumentDao.findOne(id);
	}
}
