/*******************************************************************************
 * Copyright (c) 2009, 2019 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Evgeny Mandrikov - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.test.validation.java5;

import org.jacoco.core.test.validation.Source.Line;
import org.jacoco.core.test.validation.ValidationTestBase;
import org.jacoco.core.test.validation.java5.targets.EnumSwitchTarget;

/**
 * Test of filtering of a synthetic class that is generated by javac for a enum
 * in switch statement.
 */
public class EnumSwitchTest extends ValidationTestBase {

	public EnumSwitchTest() {
		super(EnumSwitchTarget.class);
	}

	public void assertSwitch(final Line line) {
		if (isJDKCompiler && JAVA_VERSION.isBefore("1.6")) {
			// class that holds "switch map" is not marked as synthetic when
			// compiling with javac 1.5
			assertPartlyCovered(line, 0, 2);
		} else {
			assertFullyCovered(line, 0, 2);
		}
	}

}
