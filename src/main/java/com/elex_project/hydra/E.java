/******************************************************************************
 * Project Hydra; Simple HTML Snippet Builder                                 *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.hydra;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * HTML Element
 * 속성을 지정할 수 있으며, 자식 요소를 가질 수 있다.
 *
 * @author Elex
 */
public class E extends AbsElement implements IAttributable<E>, IChildAppendable<E> {

	public E() {
		this(DIV);
	}

	public E(@NotNull final String tagName) {
		super(tagName);
	}

	@Override
	public E id(@Nullable final String idVal) {
		this.id = idVal;
		return this;
	}

	@Override
	public E clazz(@NotNull final String classVal) {
		String[] vals = classVal.split(SPACE_STRING);
		if (vals.length > 1) {
			this.clazz(vals);
		} else {
			this.classes.add(classVal);
		}
		return this;
	}

	@Override
	public E clazz(@NotNull final String... classes) {
		for (String c : classes) {
			clazz(c);
		}
		return this;
	}

	@Override
	public E removeClass(@NotNull final String classVal) {
		this.classes.remove(classVal);
		return this;
	}

	@Override
	public E style(@NotNull final String name, @Nullable final String value) {
		if (isEmpty(value)) {
			this.styles.remove(name);
		} else {
			this.styles.put(name, value);
		}
		return this;
	}

	@Override
	public E attr(@NotNull final String attrName, @Nullable final String attrVal) {
		if (null == attrVal) {
			this.attributes.remove(attrName);
		} else {
			this.attributes.put(attrName, attrVal);
		}
		return this;
	}

	@Override
	public E attr(@NotNull final String attrName) {
		return attr(attrName, attrName);
	}

	@Override
	public E attr(@NotNull final String attrName, final Number attrVal) {
		return attr(attrName, String.valueOf(attrVal));
	}

	@Override
	public E attr(@NotNull final String attrName, final boolean attrVal) {
		return attr(attrName, String.valueOf(attrVal));
	}

	@Override
	public E append(@NotNull final IElement childElement) {
		children.add(childElement);
		return this;
	}

	@Override
	public E append(final int index, @NotNull final IElement childElement) {
		children.add(index, childElement);
		return this;
	}

	@Override
	public E prepend(@NotNull final IElement childElement) {
		children.add(0, childElement);
		return this;
	}

	@Override
	public E append(@NotNull final String childElement) {
		children.add(new TextNode(childElement));
		return this;
	}

	@Override
	public E append(final int index, @NotNull final String childElement) {
		children.add(index, new TextNode(childElement));
		return this;
	}

	@Override
	public E prepend(@NotNull final String childElement) {
		children.add(0, new TextNode(childElement));
		return this;
	}

	@Override
	public E removeChildren() {
		this.children.clear();
		return this;
	}

	@Override
	public E remove(final IElement child) {
		this.children.remove(child);
		return this;
	}

	@Override
	public E remove(final int child) {
		this.children.remove(child);
		return this;
	}

	@Override
	public List<IElement> getChildren() {
		return this.children;
	}


	@Override
	public @NotNull ArrayList<IElement> getChildren(final Filter filter) {
		ArrayList<IElement> list = new ArrayList<>();
		for (IElement e : children) {
			if (filter.filter(e)) list.add(e);
		}
		return list;
	}

	public E onclick(final String onclick) {
		this.attr("onclick", onclick);
		return this;
	}

}
