/******************************************************************************
 * Project Hydra; Simple HTML Snippet Builder                                 *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.hydra;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 기본 엘리먼트 구현
 * 프로퍼티 선언 그리고, render()를 구현.
 *
 * @author Elex
 */
abstract class AbsElement implements IElement {

	protected String tagName;
	protected String id;
	protected HashSet<String> classes;
	protected HashMap<String, String> styles;
	protected HashMap<String, String> attributes;
	protected ArrayList<IElement> children;

	protected AbsElement(final String tagName) {
		this.tagName = tagName;
		this.id = null;
		this.classes = new HashSet<>();
		this.styles = new HashMap<>();
		this.attributes = new HashMap<>();
		this.children = new ArrayList<>();
	}

	/**
	 * 빈 문자열 여부.
	 * 의존도를 낮추기 위해, abraxas 프로젝트에서 복제.
	 *
	 * @param str
	 * @return
	 */
	protected static boolean isEmpty(@Nullable final String str) {
		return (null == str || str.trim().equals(EMPTY_STRING));
	}

	/*
	static creators
	 */
	@NotNull
	@Contract(" -> new")
	public static E div() {
		return new E("div");
	}

	public static E div(final String text) {
		return new E("div").append(text);
	}

	@NotNull
	@Contract(" -> new")
	public static E span() {
		return new E("span");
	}

	public static E span(final String text) {
		return new E("span").append(text);
	}

	@NotNull
	@Contract(" -> new")
	public static E p() {
		return new E("p");
	}

	public static E p(final String text) {
		return new E("p").append(text);
	}

	@Contract(" -> new")
	public static @NotNull E pre() {
		return new E("pre");
	}

	public static E pre(final String text) {
		return new E("pre").append(text);
	}

	@NotNull
	@Contract("_ -> new")
	public static E h(final int lvl) {
		return new E("h" + lvl);
	}

	public static E h(final int lvl, final String text) {
		return new E("h" + lvl).append(text);
	}

	public static E a(final String href) {
		return new E("a").attr("href", href);
	}

	@NotNull
	@Contract(" -> new")
	public static E table() {
		return new E("table");
	}

	@NotNull
	@Contract(" -> new")
	public static E thead() {
		return new E("thead");
	}

	@NotNull
	@Contract(" -> new")
	public static E tbody() {
		return new E("tbody");
	}

	@NotNull
	@Contract(" -> new")
	public static E tr() {
		return new E("tr");
	}

	@NotNull
	@Contract(" -> new")
	public static E th() {
		return new E("th");
	}

	public static E th(final String text) {
		return new E("th").append(text);
	}

	@NotNull
	@Contract(" -> new")
	public static E td() {
		return new E("td");
	}

	public static E td(final String text) {
		return new E("td").append(text);
	}

	@NotNull
	@Contract(" -> new")
	public static E ul() {
		return new E("ul");
	}

	@NotNull
	@Contract(" -> new")
	public static E ol() {
		return new E("ol");
	}

	@NotNull
	@Contract(" -> new")
	public static E li() {
		return new E("li");
	}

	public static E li(final String text) {
		return new E("li").append(text);
	}

	@NotNull
	@Contract(" -> new")
	public static E dl() {
		return new E("dl");
	}

	@NotNull
	@Contract(" -> new")
	public static E dt() {
		return new E("dt");
	}

	public static E dt(final String text) {
		return new E("dt").append(text);
	}

	@NotNull
	@Contract(" -> new")
	public static E dd() {
		return new E("dd");
	}

	public static E dd(final String text) {
		return new E("dd").append(text);
	}

	public static E ruby(final String text, final String text2) {
		return new E("ruby")
				.append(text)
				.append(new E("rp").append("("))
				.append(new E("rt").append(text2))
				.append(new E("rp").append(")"));
	}

	@Contract(" -> new")
	public static @NotNull S meta() {
		return new S("meta");
	}

	public static S meta(final String name, final String content) {
		return new S("meta")
				.attr("name", name)
				.attr("content", content);
	}

	public static @NotNull S link() {
		return new S("link");
	}

	public static @NotNull S link(final String href, final String rel, final String type) {
		return new S("link")
				.attr("href", href)
				.attr("rel", rel)
				.attr("type", type);
	}

	public static @NotNull S link(final String href, final String rel) {
		return new S("link")
				.attr("href", href)
				.attr("rel", rel);
	}

	@Nullable
	public String getTagName() {
		return tagName;
	}

	@Nullable
	public String getId() {
		return id;
	}

	public boolean hasClassName(@NotNull final String clazz) {
		return classes.contains(clazz);
	}

	@NotNull
	@Override
	public String render() {
		StringBuilder sb = new StringBuilder();
		sb.append("<").append(this.tagName);

		// ID
		if (!isEmpty(this.id)) {
			sb.append(" id=\"").append(id).append("\"");
		}

		// CLASS
		if (classes.size() > 0) {
			sb.append(" class=\"");
			for (String c : classes) {
				sb.append(c).append(SPACE_STRING);
			}
			if (sb.lastIndexOf(SPACE_STRING) == sb.length() - 1) {
				sb.deleteCharAt(sb.lastIndexOf(SPACE_STRING));
			}
			sb.append("\"");
		}

		// STYLE
		if (styles.keySet().size() > 0) {
			sb.append(" style=\"");
			for (String k : styles.keySet()) {
				sb.append(k).append(":")
						.append(styles.get(k)).append(";");
			}
			sb.append("\"");
		}

		// ATTR
		for (String k : attributes.keySet()) {
			sb.append(SPACE_STRING).append(k);
			if (!k.equals(attributes.get(k))) {
				sb.append("=\"")
						.append(attributes.get(k)).append("\"");
			}
		}

		if (this instanceof IChildAppendable) {
			sb.append(">");

			// CHILDREN
			if (children.size() > 0) {
				for (IElement child : children) {
					sb.append(child.render());
				}
			}

			sb.append("</").append(this.tagName).append(">");
		} else {
			sb.append(" />");
		}

		return sb.toString();
	}

	@Override
	public <T extends IElement> IChildAppendable<T> wrap(@NotNull final IChildAppendable<T> parent) {
		parent.removeChildren();
		parent.append(this);
		return parent;
	}
}
