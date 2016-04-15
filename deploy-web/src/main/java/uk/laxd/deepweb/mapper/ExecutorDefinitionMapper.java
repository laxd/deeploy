package uk.laxd.deepweb.mapper;

import org.springframework.stereotype.Component;
import uk.laxd.deepweb.dto.ExecutorDefinitionDto;
import uk.laxd.deepweb.lang.MappingNotSupportedException;
import uk.laxd.deepweb.plugin.ExecutorDefinition;

/**
 * Created by lawrence on 15/03/16.
 */
@Component
public class ExecutorDefinitionMapper extends Mapper<ExecutorDefinitionDto, ExecutorDefinition> {
    @Override
    public ExecutorDefinition mapToEntity(ExecutorDefinitionDto dto) {
        throw new MappingNotSupportedException();
    }

    @Override
    public ExecutorDefinitionDto mapToDto(ExecutorDefinition entity) {
        ExecutorDefinitionDto dto = new ExecutorDefinitionDto();
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());

        return dto;
    }
}
