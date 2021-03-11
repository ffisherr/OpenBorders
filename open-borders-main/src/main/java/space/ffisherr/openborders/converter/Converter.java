package space.ffisherr.openborders.converter;

public interface Converter <T, E> {

    T convertFromEntity(E entity);

    E convertToEntity(T model);

}
