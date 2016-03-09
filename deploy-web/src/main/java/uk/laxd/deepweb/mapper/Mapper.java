package uk.laxd.deepweb.mapper;

public interface Mapper<D, E> {
	public E mapToEntity(D dto);
	public D mapToDto(E entity);
}
