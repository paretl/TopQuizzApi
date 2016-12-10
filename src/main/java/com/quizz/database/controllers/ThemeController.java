package com.quizz.database.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quizz.database.datas.ReturnCode;
import com.quizz.database.modeles.ReturnObject;
import com.quizz.database.services.AppService;

@Slf4j
@RestController
@RequestMapping(value = "/theme")
public class ThemeController {
	@Autowired
	private AppService appService;
	@RequestMapping("/")
	@ResponseBody
	public ResponseEntity<?> home() {
		return ResponseEntity.badRequest().body("Theme");
	}

	/**
	 *
	 * @return {@link ReturnObject}
	 */
	@RequestMapping(value = "/getAllThemes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReturnObject> getAllThemes() {
		ReturnObject object = new ReturnObject();
		try {
			object = appService.getAllThemes();
		} catch (Exception e) {
			log.error("Impossible to get Themes", e);
		}
		return ResponseEntity.ok().body(object);
	}
	
	 @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    public ResponseEntity<ReturnObject> addTheme(@RequestParam(name = "name") String name){
	        ReturnObject object = new ReturnObject();
	        try {
	            object = appService.addTheme(name);
	        }catch (Exception e){
	            log.error("Impossible to add Theme [name: " + name +"]", e);
	        }
	        return ResponseEntity.ok().body(object);
	    }
	    
	    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    public ResponseEntity<ReturnObject> deleteTheme(@RequestParam int id){
	        ReturnObject object = new ReturnObject();
	        try {
	            object = appService.deleteTheme(id);
	        }catch (Exception e) {
	            log.error("Impossible to delete ThemeException [id: " + id + "]", e);
	            object.setCode(ReturnCode.ERROR_100);
	        }
	        return ResponseEntity.ok().body(object);
	    }
	    
	    @RequestMapping(value = "/getByName", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    public ResponseEntity<ReturnObject> getThemeByName(@RequestParam(name = "name") String name){
	        ReturnObject object = new ReturnObject();
	        try {
	            object = appService.getThemeByName(name);
	        }catch (Exception e) {
	            log.error("Impossible to get Theme [name: " + name + "]", e);
	        }
	        return ResponseEntity.ok().body(object);
	    }
}