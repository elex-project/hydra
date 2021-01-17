/******************************************************************************
 * Project Hydra; Simple HTML Snippet Builder                                 *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.hydra;

import org.jetbrains.annotations.NotNull;

/**
 * @author Elex
 */
public interface IRenderable extends Consts {
	/**
	 * HTML 문자열로 변환
	 *
	 * @return Compiled HTML String
	 */
	@NotNull String render();
}
