/*
 * This file is part of Spout.
 *
 * Copyright (c) 2011-2012, SpoutDev <http://www.spout.org/>
 * Spout is licensed under the SpoutDev License Version 1.
 *
 * Spout is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Spout is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.engine.util.thread.coretasks;

import java.io.Serializable;

import org.spout.engine.util.thread.AsyncExecutor;
import org.spout.engine.util.thread.ManagementRunnable;
import org.spout.engine.util.thread.ManagementTaskEnum;

public class StartTickTask extends ManagementRunnable {
	private static final long serialVersionUID = 1L;
	private long delta;
	private int stage;

	public StartTickTask() {
		delta = 0;
	}

	public StartTickTask(int stage, long delta) {
		this.stage = stage;
		this.delta = delta;
	}

	public StartTickTask setStageDelta(int stage, long delta) {
		this.delta = delta;
		this.stage = stage;
		return this;
	}

	@Override
	public Serializable call(AsyncExecutor executor) throws InterruptedException {
		executor.getManager().startTickRun(stage, delta);
		return null;
	}

	@Override
	public ManagementTaskEnum getEnum() {
		return ManagementTaskEnum.START_TICK;
	}
}