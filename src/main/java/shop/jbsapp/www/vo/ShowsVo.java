package shop.jbsapp.www.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShowsVo {
	private int id;
	private int movieId;
	private Date beginTime;
	private Date endTime;
	private int roomId;
	private int price;
}
