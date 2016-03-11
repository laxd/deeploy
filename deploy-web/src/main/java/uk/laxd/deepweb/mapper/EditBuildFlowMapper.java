package uk.laxd.deepweb.mapper;

import uk.laxd.deepweb.dto.EditBuildFlowDto;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.lang.MappingNotSupportedException;
import org.springframework.stereotype.Component;

@Component
public class EditBuildFlowMapper extends Mapper<EditBuildFlowDto, BuildFlow> {
	public BuildFlow mapToEntity(EditBuildFlowDto editBuildFlowDto) {
		BuildFlow buildFlow = new BuildFlow();
		
		buildFlow.setName(editBuildFlowDto.getName());

		return buildFlow;
	}

	public EditBuildFlowDto mapToDto(BuildFlow buildFlow) {
		EditBuildFlowDto editBuildFlowDto = new EditBuildFlowDto();

		editBuildFlowDto.setName(buildFlow.getName());

		return editBuildFlowDto;
	}
}
