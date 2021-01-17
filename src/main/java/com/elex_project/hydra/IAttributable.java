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
 * HTML 프로퍼티를 가질 수 있다.
 *
 * @author Elex
 */
public interface IAttributable<T extends IElement> extends IElement {

	/**
	 * ID
	 * 제거하려면 null을 전달.
	 *
	 * @param idVal 아이디 명
	 * @return
	 */
	T id(@Nullable String idVal);

	/**
	 * CLASS 추가
	 *
	 * @param classVal 클래스 명
	 * @return
	 */
	T clazz(@NotNull String classVal);

	/**
	 * CLASS 추가
	 *
	 * @param classes
	 * @return
	 */
	T clazz(@NotNull String... classes);

	/**
	 * CLASS 제거
	 *
	 * @param classVal 클래스 명
	 * @return
	 */
	T removeClass(@NotNull String classVal);

	/**
	 * 인라인 스타일을 추가
	 *
	 * @param name
	 * @param value 제거하려면 null을 전달.
	 * @return
	 */
	T style(@NotNull String name, @Nullable String value);

	/**
	 * 속성 추가
	 *
	 * @param attrName 속성 명
	 * @param attrVal  속성 값. 제거하려면 null을 전달.
	 * @return
	 */
	T attr(@NotNull String attrName, @Nullable String attrVal);

	T attr(@NotNull String attrName);

	/**
	 * 속성 추가
	 *
	 * @param attrName
	 * @param attrVal  제거하려면 null을 전달.
	 * @return
	 */
	T attr(@NotNull String attrName, @Nullable Number attrVal);

	/**
	 * 속성 추가
	 *
	 * @param attrName
	 * @param attrVal
	 * @return
	 */
	T attr(@NotNull String attrName, boolean attrVal);
}
