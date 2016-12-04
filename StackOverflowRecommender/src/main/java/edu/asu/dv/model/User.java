package edu.asu.dv.model;

public class User {

	private String user_id;

	private String user_name;

	private Integer answer_count;

	private Integer answer_score;

	private Integer question_count;

	private Integer question_score;

	private String tag_name;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Integer getAnswer_count() {
		return answer_count;
	}

	public void setAnswer_count(Integer answer_count) {
		this.answer_count = answer_count;
	}

	public Integer getAnswer_score() {
		return answer_score;
	}

	public void setAnswer_score(Integer answer_score) {
		this.answer_score = answer_score;
	}

	public Integer getQuestion_count() {
		return question_count;
	}

	public void setQuestion_count(Integer question_count) {
		this.question_count = question_count;
	}

	public Integer getQuestion_score() {
		return question_score;
	}

	public void setQuestion_score(Integer question_score) {
		this.question_score = question_score;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Override
	public String toString() {
		return "User [user_name=" + user_name + ",user_id=" + user_id + ", answer_count=" + answer_count
				+ ", answer_score=" + answer_score + ", question_count=" + question_count + ", question_score="
				+ question_score + ", tag_name=" + tag_name + "]";
	}

}
