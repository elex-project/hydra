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
public class JSObjectTest {

	@Test
	public void render() {
		String s = null;
		String out = new JSObject()
				.put("name", "Charlie")
				.put("age", 14)
				.put("adult", false)
				.put("favorite", new JSArray().add("A").add(3).add("7").add(true))
				.put("state", new JSStatement("eval('k')"))
				.put("other", new JSObject().put("mother", "Mary").put("oop", s))
				.render();

		log.info(out);
	}
}
