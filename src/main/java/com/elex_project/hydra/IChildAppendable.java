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
 * 자식 노드를 가질 수 있다.
 *
 * @param <T>
 * @author Elex
 */
public interface IChildAppendable<T extends IElement> extends IElement {
	/**
	 * 자식 노드를 맨 뒤에 추가
	 *
	 * @param childElement 자식 노드
	 * @return
	 */
	T append(@NotNull IElement childElement);

	/**
	 * 자식 노드를 특정 위치에 추가
	 *
	 * @param index
	 * @param childElement 자식 노드
	 * @return
	 */
	T append(int index, @NotNull IElement childElement);

	/**
	 * 자식 노드를 맨 앞에 추가
	 *
	 * @param childElement 자식 노드
	 * @return
	 */
	T prepend(@NotNull IElement childElement);

	/**
	 * 자식 노드를 추가
	 *
	 * @param childElement 자식 노드
	 * @return
	 */
	T append(@NotNull String childElement);

	/**
	 * 자식 노드를 추가
	 *
	 * @param index
	 * @param childElement 자식 노드
	 * @return
	 */
	T append(int index, @NotNull String childElement);

	/**
	 * 자식 노드를 추가
	 *
	 * @param childElement 자식 노드
	 * @return
	 */
	T prepend(@NotNull String childElement);


	/**
	 * 자식 노드를 제거
	 *
	 * @param child 자식 노드
	 * @return
	 */
	T remove(@Nullable IElement child);

	/**
	 * 자식 노드를 제거
	 *
	 * @param child 자식 노드 인덱스
	 * @return
	 */
	T remove(int child);

	/**
	 * 모든 자식 노드를 제거
	 *
	 * @return
	 */
	T removeChildren();

	/**
	 * 자식 요소 리스트
	 *
	 * @return 리스트
	 */
	List<IElement> getChildren();

	ArrayList<IElement> getChildren(Filter filter);

	public interface Filter {
		boolean filter(IElement elem);
	}
}
