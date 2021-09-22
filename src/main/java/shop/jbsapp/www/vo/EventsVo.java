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
public class EventsVo {
	private int id;
	private String title;
	private String content;
	private Date createDate;
	private String mainImage;
	private String detailImage;
}
