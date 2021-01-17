/******************************************************************************
 * Project Hydra; Simple HTML Snippet Builder                                 *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.hydra;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * 자바스크립트 배열을 생성.
 * JSON과는 다르다.
 *
 * @author Elex
 */
public class JSArray implements IRenderable {
	private final ArrayList<Object> list;

	public JSArray() {
		this.list = new ArrayList<>();
	}

	private static void cleanUpTailingComma(@NotNull final StringBuilder sb) {
		JSObject.cleanUpTailingComma(sb);
	}

	@NotNull
	@Contract(pure = true)
	private static String bool(final boolean v) {
		return JSObject.bool(v);
	}

	public JSArray add(final String item) {
		list.add(item);
		return this;
	}

	public JSArray add(final Number item) {
		list.add(item);
		return this;
	}

	public JSArray add(final Boolean item) {
		list.add(item);
		return this;
	}

	public JSArray add(final JSObject item) {
		list.add(item);
		return this;
	}

	public JSArray add(final JSArray item) {
		list.add(item);
		return this;
	}

	public JSArray add(final JSStatement item) {
		list.add(item);
		return this;
	}

	@Override
	public @NotNull String render() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Object item : list) {
			if (null == item) {
				sb.append("null");
			} else if (item instanceof String) {
				sb.append("\"").append(item).append("\"");
			} else if (item instanceof Number) {
				sb.append(item);
			} else if (item instanceof Boolean) {
				sb.append(bool((Boolean) item));
			} else if (item instanceof IRenderable) {
				sb.append(((IRenderable) item).render());
			}
			sb.append(COMMA);
		}
		cleanUpTailingComma(sb);
		sb.append("]");
		return sb.toString();
	}
}
