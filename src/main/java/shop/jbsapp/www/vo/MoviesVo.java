package shop.jbsapp.www.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MoviesVo {
	private int id;
	private String title;
	private String content;
	private String director;
	private String genre;
	private String rating;
	private String image;
}
