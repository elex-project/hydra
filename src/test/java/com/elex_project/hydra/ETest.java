/******************************************************************************
 * Project Hydra; Simple HTML Snippet Builder                                 *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.hydra;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ETest {

	@Test
	public void render() {
		E e = new E("p");
		e.id("my-elem")
				.clazz("card card-red card-primary")
				.clazz("card-1-dp")
				.attr("data-elem", "true");

		e.append("Hello, ");
		e.style("background", "#fff")
				.style("color", "transparent");
		e.append(new E("span").append("World")).append(".");
		e.prepend("??");
		String out = e.render();

		log.info(out);

		S s = S.link();
		s.clazz("mdl", "small")
				.wrap(e.removeClass("card-1-dp"));
		out = e.render();
		log.info(out);
	}

	@Test
	public void render_ruby() {
		E e = E.ruby("趙康欽", "조강흠");
		log.info(e.render());
	}

	@Test
	public void renderWrap() {
		TextNode txt = new TextNode("Hello");
		String out = txt
				.wrap(E.p())
				.wrap(E.div()
						.attr("data-h", "mmm"))
				.render();
		log.info(out);
	}

}
