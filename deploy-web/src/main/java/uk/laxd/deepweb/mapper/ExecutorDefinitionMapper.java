package uk.laxd.deepweb.mapper;

import org.springframework.stereotype.Component;
import uk.laxd.deepweb.dto.ExecutorDefinitionDto;
import uk.laxd.deepweb.plugin.PluginDefinition;

/**
 * Created by lawrence on 15/03/16.
 */
@Component
public class ExecutorDefinitionMapper extends Mapper<ExecutorDefinitionDto, PluginDefinition> {
    @Override
    public PluginDefinition mapToEntity(ExecutorDefinitionDto dto) {
        PluginDefinition executor = new PluginDefinition();
        executor.setName(dto.getName());

        return executor;
    }

    @Override
    public ExecutorDefinitionDto mapToDto(PluginDefinition entity) {
        ExecutorDefinitionDto dto = new ExecutorDefinitionDto();
        dto.setName(entity.getName());

        return dto;
    }
}
