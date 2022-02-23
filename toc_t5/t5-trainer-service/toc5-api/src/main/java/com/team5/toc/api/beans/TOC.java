package com.team5.toc.api.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="toc")
public class TOC {
	/**
	 * 
	 * @author Anurag
	 * @see 
	 * @since Feb 2022
	 *
	 */
	@Id
	private int id;
	private String courseName;
	private int courseDuration;
	private String courseObjective;
	private String coursePreRequisites;
	private String courseFor;
	private int courseCreatedBy;
}
