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
public class BooksVo {
	private int id;
	private int showId;
	private Date createDate;
	private int price;
	private String userId;
	private String seatNum;
}
