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
public class CustomersVo {
	private int id;
	private String title;
	private String content;
	private int ref;
	private int lev;
	private int step;
	private Date createDate;
	private String userId;
}
