package com.vs.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	// STEPS:
	// 1) Annotate the class as an entity and map to DB table.
	// 2) Define the fields.
	// 3) Annotate the fields with DB column names.
	// 4) Create constructors.
	// 5) Generate getters and setters.
	// 6) Generate toString() method.
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	// IMPORTANT
	// Add new field for instructor (also add getter / setter).
	// "instructorDetail" is a field in "Instructor" class.
	// This field was not present in OneToOne unidirectional mapping.
	@OneToOne(mappedBy="instructorDetail", cascade=CascadeType.ALL)
	private Instructor instructor;
	
	/*
	 * IMPORTANT
	 * 
	 * To make the relation bidirectional but prevent cascading delete (i.e, delete the instructor detail but keep the instructor):
	 * 
	 * 	STEP 1: (change cascade type)
	 * 		@OneToOne(mappedBy="instructorDetail", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	 *		private Instructor instructor;
	 *
	 * 	STEP 2: (remove the link and then delete. NOTE: "ind" is InstructorDetail object.)
	 * 		ind.getInstructor().setInstructorDetail(null);
	 * 		session.delete(ind);
	 */
	
	public InstructorDetail() {
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
}
