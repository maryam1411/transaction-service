package com.example.transaction.transformer;

public interface Transformer<M,E> {

    E toEntity(M m);

    M toModel(E e);
}
