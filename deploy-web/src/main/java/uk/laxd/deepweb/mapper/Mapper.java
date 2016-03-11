package uk.laxd.deepweb.mapper;

import java.util.Collection;
import java.util.ArrayList;

public abstract class Mapper<D, E> {
	public abstract E mapToEntity(D dto);
	public abstract D mapToDto(E entity);

	public Collection<E> mapToEntities(Collection<D> dtos) {
		Collection<E> entities = new ArrayList<E>();

		for(D dto : dtos) {
			entities.add(mapToEntity(dto));
		}

		return entities;
	}

	public Collection<D> mapToDtos(Collection<E> entities) {
		Collection<D> dtos = new ArrayList<D>();

		for(E entity : entities) {
			dtos.add(mapToDto(entity));
		}

		return dtos;
	}

}
