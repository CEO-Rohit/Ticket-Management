package ai.ineuron.error;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
	
	private LocalDateTime time;
	private String msg;
	private String status;
}
