package com.kirscd.demo.singleton;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Simple example which implements a singleton print spooler using an enum, rather than
 * a more explicit class.
 */
public enum PrintSpooler {
	INSTANCE;

	private final int SPOOL_SIZE = 10;
	private final ArrayBlockingQueue<String> printJobs = new ArrayBlockingQueue<String>(SPOOL_SIZE);
	
	/**
	 * Used by different threads to submit jobs
	 * @param jobName the name of the job to submit
	 * @return whether the job was successfully added or not
	 */
	public boolean addJob(String jobName) {
		return printJobs.offer(jobName);
	}

	/**
	 * Used by the printing thread to determine which job is next to be printed
	 *
	 * @return a String indicating the next job to be printed, or null if the queue is empty
	 */
	public String getNextJob() {
		return printJobs.poll();
	}
}
