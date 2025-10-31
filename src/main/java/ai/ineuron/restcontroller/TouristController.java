package ai.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.ineuron.model.Tourist;
import ai.ineuron.service.ITouristService;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	private ITouristService service;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {

		String status = service.registerTourist(tourist);
		return new ResponseEntity<String>(status, HttpStatus.OK);

	}

	@GetMapping("/findAll")
	public ResponseEntity<?> fetchAll() {

		List<Tourist> tourists = service.fetchAllTourist();
		return new ResponseEntity<List<Tourist>>(tourists, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> fetchById(@PathVariable Integer id) {

		Tourist tourist = service.fetchTouristById(id);
		return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);

	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {

		String msg = service.updateTouristData(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@PatchMapping("/update/{id}/{hikeAmount}")
	public ResponseEntity<String> modifyTouristById(@PathVariable Integer id, @PathVariable Float hikeAmount) {

		String msg = service.updateTouristById(id, hikeAmount);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> removeById(@PathVariable Integer id) {

		String msg = service.deleteTouristById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
