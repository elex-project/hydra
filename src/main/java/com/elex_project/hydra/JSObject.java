/******************************************************************************
 * Project Hydra; Simple HTML Snippet Builder                                 *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.hydra;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * 자바스크립트 객체를 생성.
 * JSON과는 다르다.
 *
 * @author Elex
 */
public class JSObject implements IRenderable {
	private final HashMap<String, Object> properties;

	public JSObject() {
		this.properties = new HashMap<>();
	}

	static void cleanUpTailingComma(@NotNull final StringBuilder sb) {
		if (sb.lastIndexOf(COMMA) == sb.length() - 1) sb.deleteCharAt(sb.lastIndexOf(COMMA));
	}

	@NotNull
	@Contract(pure = true)
	static String bool(final boolean v) {
		return v ? "true" : "false";
	}

	public JSObject put(final String k, final String v) {
		properties.put(k, v);
		return this;
	}

	public JSObject put(final String k, final Number v) {
		properties.put(k, v);
		return this;
	}

	public JSObject put(final String k, final Boolean v) {
		properties.put(k, v);
		return this;
	}

	public JSObject put(final String k, final JSObject v) {
		properties.put(k, v);
		return this;
	}

	public JSObject put(final String k, final JSArray v) {
		properties.put(k, v);
		return this;
	}

	public JSObject put(final String k, final JSStatement v) {
		properties.put(k, v);
		return this;
	}

	@Override
	public @NotNull String render() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (String k : properties.keySet()) {
			sb.append(k).append(":");
			Object v = properties.get(k);
			if (null == v) {
				sb.append("null");
			} else if (v instanceof String) {
				sb.append("\"").append(v).append("\"");
			} else if (v instanceof Number) {
				sb.append(v);
			} else if (v instanceof Boolean) {
				sb.append(bool((Boolean) v));
			} else if (v instanceof IRenderable) {
				sb.append(((IRenderable) v).render());
			}
			sb.append(COMMA);
		}
		cleanUpTailingComma(sb);
		sb.append("}");
		return sb.toString();
	}
}
