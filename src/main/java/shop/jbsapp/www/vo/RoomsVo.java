package shop.jbsapp.www.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomsVo {
	private int id;
	private String theaterName;
	private int seatCount;
	private String location;
	private int roomNum;
}
