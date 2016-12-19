package com.quizz.database.services;

import java.util.Collection;

import com.quizz.database.modeles.Question;
import com.quizz.database.modeles.ReturnObject;
/**
 * 
 * {@link ThemeService} will validate data and call {@link ThemeRepository} 
 * 
 * @author Romain Chazottier
 * @version 1.0
 * @since 25/11/2016
 * 
 */
public interface ThemeService {

	public ReturnObject getThemeByName(String name);

	public ReturnObject getAllThemes();

	public ReturnObject addTheme(String name);

	public ReturnObject deleteTheme(int id);
	
	public ReturnObject addThemeWithIdQuestion(String name, int idQuestion);
	
	public ReturnObject getAllThemesByUser(Collection<Question> questions);
}
