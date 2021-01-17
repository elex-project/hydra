/******************************************************************************
 * Project Hydra; Simple HTML Snippet Builder                                 *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.hydra;

import org.jetbrains.annotations.NotNull;

/**
 * 텍스트 노드
 *
 * @author Elex
 */
public class TextNode implements IElement {
	private String text;

	public TextNode(final String text) {
		setText(text);
	}

	public void setText(final String text) {
		this.text = text;
	}

	@Override
	public @NotNull String render() {
		return text;
	}

	@Override
	public <T extends IElement> IChildAppendable<T> wrap(@NotNull final IChildAppendable<T> parent) {
		parent.removeChildren();
		parent.append(this);
		return parent;
	}
}
