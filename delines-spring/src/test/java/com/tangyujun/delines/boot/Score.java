package com.tangyujun.delines.boot;

import cn.hutool.core.convert.impl.StringConverter;
import com.tangyujun.delines.AbstractDelinesEntity;
import com.tangyujun.delines.Delines;
import com.tangyujun.delines.annotation.DelinesEntity;
import com.tangyujun.delines.annotation.DelinesField;

@DelinesEntity(rangeStartType = DelinesEntity.RangeType.NUMBER, rangeStart = "1", required = "[\\u4e00-\\u9fa5]+.*")
public class Score extends AbstractDelinesEntity {
	@DelinesField(regExp = "[\\u4e00-\\u9fa5]+")
	private String course;
	@DelinesField(regExp = "\\b\\d{1,3}\\b")
	private Integer score;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Score{" +
				"course='" + course + '\'' +
				", score=" + score +
				'}';
	}

	public static void main(String[] args) {
		String[] lines = new String[]{"P01 小明 14 M 19990909", "P02 小霞 15 F 19990912"};
		Person person = null;
		for (String line : lines) {
			// 必须在Spring项目中使用，能拿到SpringBeanFactory，否则会报NullPointerException
			person = SpringDelines.with(line, Person.class);
			System.out.println(person);
		}
	}
}