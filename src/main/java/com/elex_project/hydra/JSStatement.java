/******************************************************************************
 * Project Hydra; Simple HTML Snippet Builder                                 *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.hydra;

import org.jetbrains.annotations.NotNull;

/**
 * 따옴표 처리를 하지 않을 문자열
 *
 * @author Elex
 */
public class JSStatement implements IRenderable {
	private final String statement;

	public JSStatement(@NotNull final String statement) {
		this.statement = statement;
	}

	@Override
	public @NotNull String render() {
		return statement;
	}
}
