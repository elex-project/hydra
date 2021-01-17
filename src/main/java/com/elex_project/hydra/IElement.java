/******************************************************************************
 * Project Hydra; Simple HTML Snippet Builder                                 *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.hydra;

/**
 * @author Elex
 */
public interface IElement extends IRenderable, Consts {

	/**
	 * 부모 요소로 감싼다.
	 * 만일, 부모 요소가 자식을 갖고 있었다면, 모두 사라지고, 하나의 자식만 남는다.
	 *
	 * @param parent 부모 요소
	 * @return 부모 요소가 반환된다. 그래야 render()를 호출하기가 편하다.
	 */
	<T extends IElement> IChildAppendable<T> wrap(IChildAppendable<T> parent);
}
