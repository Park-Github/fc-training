package fastcampus.memorydb.db;

import fastcampus.memorydb.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    private List<T> dataList = new ArrayList<>();

    private static Long index = 0L;

    public Comparator<T> sort = new Comparator<>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    // C
    @Override
    public T save(T data) {
        if (Objects.isNull(data)) {
            throw new RuntimeException("Data is null");
        }

        var preData = dataList.stream()
                .filter(e -> {
                    return e.getId().equals(data.getId());
                })
                .findFirst();

        if (preData.isPresent()) {
            dataList.remove(preData.get());
            dataList.add(data);
        }
        else {
            index++;
            data.setId(index);
            dataList.add(data);
        }

        data.setId(index);
        dataList.add(data);

        index++;
        return data;
    }
    // Read
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }

    // Delete
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(e -> {
                    return e.getId().equals(id);
                })
                .findFirst();

        if (deleteEntity.isPresent()) {
            dataList.remove(deleteEntity.get());
        }
    }
}
