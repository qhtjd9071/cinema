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
public class PaysVo {
	private String id;
	private int bookId;
	private String method;
	private int total;
	private Date createDate;
	
}