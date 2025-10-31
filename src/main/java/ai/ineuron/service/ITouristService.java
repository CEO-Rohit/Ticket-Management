package ai.ineuron.service;

import java.util.List;

import ai.ineuron.model.Tourist;

public interface ITouristService {
	
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristById(Integer id);
	public String updateTouristData(Tourist tourist);
	public String updateTouristById(Integer id, Float hikeAmount);
	public String deleteTouristById(Integer id);

}
