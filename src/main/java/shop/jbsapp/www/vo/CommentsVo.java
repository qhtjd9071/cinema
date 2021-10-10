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
public class CommentsVo {
	private int id;
	private String userId;
	private String content;
	private int star;
	private Date createDate;
	private int movieId;
}
