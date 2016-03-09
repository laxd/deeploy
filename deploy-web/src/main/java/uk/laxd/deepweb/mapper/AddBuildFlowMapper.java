package uk.laxd.deepweb.mapper;

import uk.laxd.deepweb.dto.AddBuildFlowDto;
import uk.laxd.deepweb.model.BuildFlow;
import uk.laxd.deepweb.lang.MappingNotSupportedException;
import org.springframework.stereotype.Component;

@Component
public class AddBuildFlowMapper implements Mapper<AddBuildFlowDto, BuildFlow> {
	public BuildFlow mapToEntity(AddBuildFlowDto addBuildFlowDto) {
		BuildFlow buildFlow = new BuildFlow();
		
		buildFlow.setName(addBuildFlowDto.getName());

		return buildFlow;
	}

	public AddBuildFlowDto mapToDto(BuildFlow buildFlow) {
		throw new MappingNotSupportedException();
	}
}
