package uk.laxd.deepweb.mapper;

import uk.laxd.deepweb.dto.ViewBuildFlowStepDto;
import uk.laxd.deepweb.lang.MappingNotSupportedException;
import uk.laxd.deepweb.model.BuildFlowStep;
import org.springframework.stereotype.Component;

@Component
public class ViewBuildFlowStepMapper extends Mapper<ViewBuildFlowStepDto, BuildFlowStep> {
	public BuildFlowStep mapToEntity(ViewBuildFlowStepDto viewBuildFlowStepDto) {
		throw new MappingNotSupportedException();
	}

	public ViewBuildFlowStepDto mapToDto(BuildFlowStep buildFlowStep) {
		ViewBuildFlowStepDto viewBuildFlowStepDto = new ViewBuildFlowStepDto();

		viewBuildFlowStepDto.setName(buildFlowStep.getExecutor().getName());
		viewBuildFlowStepDto.setType(buildFlowStep.getExecutor().getType());

		return viewBuildFlowStepDto;
	}
}
