package com.tech.subash.design.patterns.iterator;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MyCustomIteratorImpl<T> implements MyCustomContainer<T> {
   private final List<T> items;

    @Override
    public MyCustomIterator<T> iterator() {
        return new GenericCustomIterator();
    }

    private class GenericCustomIterator implements MyCustomIterator<T> {
        private  int size;

        @Override
        public boolean hasNext() {
            return size < items.size();
        }

        @Override
        public T next() {
            return hasNext() ? items.get(size++) : null;
        }
    }
}
