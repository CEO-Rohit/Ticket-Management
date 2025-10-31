package ai.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.ineuron.ExceptionHandling.TouristExceptionHandling;
import ai.ineuron.dao.ITouristDAO;
import ai.ineuron.model.Tourist;

@Service
public class TouristServiceImpl implements ITouristService {

	@Autowired
	private ITouristDAO repo;

	@Override
	public String registerTourist(Tourist tourist) {

		Integer id = repo.save(tourist).getId();
		return "Tourish Registered Successfully with id:: " + id;
	}

	@Override
	public List<Tourist> fetchAllTourist() {

		List<Tourist> list = (List<Tourist>) repo.findAll();
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer id) {
		/*
		 * Optional<Tourist> optional = repo.findById(id); if (optional.isPresent())
		 * return optional.get(); else throw new
		 * TouristExceptionHandling("Tourist with id:: "+id + "not Found");
		 */

		return repo.findById(id)
				.orElseThrow(() -> new TouristExceptionHandling("Tourist with the id:: " + id + " not Found"));
	}

	@Override
	public String updateTouristData(Tourist tourist) {

		Optional<Tourist> optional = repo.findById(tourist.getId());
		if (optional.isPresent()) {
			repo.save(tourist);
			return "Tourist with id:: " + tourist.getId() + "  is Updated";
		} else {
			throw new TouristExceptionHandling("tourist with id:: " + tourist.getId() + " not available");
		}
	}

	@Override
	public String updateTouristById(Integer id, Float hikeAmount) {
		
		Optional<Tourist> optional = repo.findById(id);
		if (optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*(hikeAmount/100)));
			repo.save(tourist);
			return "Tourist budget updated with id:: "+id+"  successfully";
		} else {
			throw new TouristExceptionHandling("tourist with id:: " + id + " not available");
		}
	}

	@Override
	public String deleteTouristById(Integer id) {
		
		Optional<Tourist> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return "record with the id:: "+id+" deleted successfully....";
		} else {
			throw new TouristExceptionHandling("tourist with id:: " + id + " not available");
		}
	}

}
