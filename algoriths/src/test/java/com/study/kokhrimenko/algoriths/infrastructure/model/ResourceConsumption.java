package com.study.kokhrimenko.algoriths.infrastructure.model;

public class ResourceConsumption {
	private static final long MEGABYTE = 1024L * 1024L;

	final long elapsedTime;
	final long memoryUsage;
	final long totalMemory;
	final long freeSize;
	
	public ResourceConsumption(long elapsedTime, long memorySize, long freeSize) {
		super();
		this.elapsedTime = elapsedTime;
		this.memoryUsage = memorySize - freeSize;
		this.totalMemory = memorySize;
		this.freeSize = freeSize;
	}
	public long getElapsedTime() {
		return elapsedTime;
	}
	public long getMemoryUsage() {
		return memoryUsage;
	}
	public long getMemorySize() {
		return totalMemory;
	}
	public long getFreeSize() {
		return freeSize;
	}
	@Override
	public String toString() {
		return "ResourceConsumption: \n\t\t\t[ elapsedTime=" + elapsedTime + " mills, memoryUsage=" + bytesToMegabytes(memoryUsage) + "MB, totalMemory="
				+ bytesToMegabytes(totalMemory) + "MB, freeSize=" + bytesToMegabytes(freeSize) + "MB ];";
	}
	
	private double bytesToMegabytes(long bytes) {
        return Math.round(bytes / MEGABYTE);
    }
}
