package uk.laxd.deepweb.mapper;

import java.util.Collection;
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class Mapper<D, E> {
	public abstract E mapToEntity(D dto);
	public abstract D mapToDto(E entity);

	public Collection<E> mapToEntities(Collection<D> dtos) {
		return dtos == null ?  new ArrayList<>() : dtos.stream()
				.map(this::mapToEntity)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public Collection<D> mapToDtos(Collection<E> entities) {
		return entities == null ?  new ArrayList<>() : entities.stream()
				.map(this::mapToDto)
				.collect(Collectors.toCollection(ArrayList::new));
	}

}
