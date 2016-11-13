package com.quizz.database.modeles;

import java.io.Serializable;

import com.quizz.database.beans.ThemeBean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Theme implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;
	
	public ThemeBean convertToBean(){
		ThemeBean bean = new ThemeBean();
		bean.setId(this.id);
		bean.setName(this.name);
		
		return bean;
	}
}