package com.javagists.jerseyfilms;


import com.javagists.jerseyfilms.filter.CustomLoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.javagists.jerseyfilms.controller.FilmController;

@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
//		register(FilmController.class);
		register(CustomLoggingFilter.class);
		packages("com.javagists.jerseyfilms");
	}
}