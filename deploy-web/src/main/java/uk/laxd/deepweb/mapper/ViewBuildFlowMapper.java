package uk.laxd.deepweb.mapper;

import uk.laxd.deepweb.dto.ViewBuildFlowDto;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.lang.MappingNotSupportedException;
import org.springframework.stereotype.Component;

@Component
public class ViewBuildFlowMapper extends Mapper<ViewBuildFlowDto, BuildFlow> {

	public BuildFlow mapToEntity(ViewBuildFlowDto viewBuildFlowDto) {
		throw new MappingNotSupportedException();
	}
	
	public ViewBuildFlowDto mapToDto(BuildFlow buildFlow) {
		ViewBuildFlowDto viewBuildFlowDto = new ViewBuildFlowDto();

		viewBuildFlowDto.setId(buildFlow.getId());
		viewBuildFlowDto.setName(buildFlow.getName());

		return viewBuildFlowDto;
	}
}
