package ai.ineuron.dao;

import org.springframework.data.repository.CrudRepository;

import ai.ineuron.model.Tourist;

public interface ITouristDAO extends CrudRepository<Tourist, Integer> {

}
