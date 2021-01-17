/******************************************************************************
 * Project Hydra; Simple HTML Snippet Builder                                 *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.hydra;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 속성 지정 가능한 HTML 요소.
 * 그러나, 자식 노드는 가질 수 없다.
 *
 * @author Elex
 */
public class S extends AbsElement
		implements IAttributable<S> {

	public S(final String tagName) {
		super(tagName);
	}

	@Override
	public S id(@Nullable final String idVal) {
		this.id = idVal;
		return this;
	}

	@Override
	public S clazz(@NotNull final String classVal) {
		String[] vals = classVal.split(SPACE_STRING);
		if (vals.length > 1) {
			this.clazz(vals);
		} else {
			this.classes.add(classVal);
		}
		return this;
	}

	@Override
	public S clazz(@NotNull final String... classes) {
		for (String c : classes) {
			clazz(c);
		}
		return this;
	}

	@Override
	public S removeClass(@NotNull final String classVal) {
		this.classes.remove(classVal);
		return this;
	}

	@Override
	public S style(@NotNull final String name, @Nullable final String value) {
		if (isEmpty(value)) {
			this.styles.remove(name);
		} else {
			this.styles.put(name, value);
		}
		return this;
	}

	@Override
	public S attr(@NotNull final String attrName, @Nullable final String attrVal) {
		if (null == attrVal) {
			this.attributes.remove(attrName);
		} else {
			this.attributes.put(attrName, attrVal);
		}
		return this;
	}

	@Override
	public S attr(@NotNull final String attrName) {
		return attr(attrName, attrName);
	}

	@Override
	public S attr(@NotNull final String attrName, final Number attrVal) {
		return attr(attrName, String.valueOf(attrVal));
	}

	@Override
	public S attr(@NotNull final String attrName, final boolean attrVal) {
		return attr(attrName, String.valueOf(attrVal));
	}

}
