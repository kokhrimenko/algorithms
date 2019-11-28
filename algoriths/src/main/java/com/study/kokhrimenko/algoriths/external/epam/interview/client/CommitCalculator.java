package com.study.kokhrimenko.algoriths.external.epam.interview.client;

import java.util.HashSet;
import java.util.Set;

/**
 * Found common parent for 2 commits.
 * 
 * Examples:
 * 
 * Case1:
 * 			commitA: #aaaaa1 #aaaaa2 #aaaaa3 #aaaaa4
 * 			commitB: #bbbbb1 #bbbbb2
 * 			result: null
 * Case2:
 * 			commitA: #aaaaa1 #aaaaa2 #aaaaa3 #aaaaa4
 * 			commitB: #bbbbb1 #bbbbb2 #aaaaa2
 * 			result: #aaaaa2
 *
 * @author kostic
 *
 */
public class CommitCalculator {

	public static class Commit {
		private final String hash;
		private final Commit parent;

		public Commit(String hash, Commit parent) {
			super();
			this.hash = hash;
			this.parent = parent;
		}

		public String getHash() {
			return hash;
		}

		public Commit getParent() {
			return parent;
		}

		@Override
		public String toString() {
			return "Commit [hash=" + hash + "]";
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TC1 with all empties
		Commit commitA1 = new Commit("", null);
		Commit commitB1 = new Commit("", null);
		System.out.println(String.format("TestCase1: common parrent between commitA: %s and commitB: %s is:%s",
				commitA1, commitB1, findCommonParent(commitA1, commitB1)));
		System.out.println("------------------------------------------");

		// TC2 with histories for commitA and null as the commitB
		Commit commitA2 = new Commit("aaaa1",
				new Commit("aaaa2", new Commit("aaaaa3", new Commit("aaaa4", new Commit("aaaa5", null)))));
		Commit commitB2 = null;
		System.out.println(String.format("TestCase2: common parrent between commitA: %s and commitB: %s is:%s",
				commitA2, commitB2, findCommonParent(commitA2, commitB2)));
		System.out.println("------------------------------------------");

		// TC3 without common parent
		Commit commitA3 = new Commit("aaaa1",
				new Commit("aaaa2", new Commit("aaaaa3", new Commit("aaaa4", new Commit("aaaa5", null)))));
		Commit commitB3 = new Commit("bbbb1", new Commit("bbbb2", new Commit("bbbb3", null)));
		System.out.println(String.format("TestCase3: common parrent between commitA: %s and commitB: %s is:%s",
				commitA3, commitB3, findCommonParent(commitA3, commitB3)));
		System.out.println("------------------------------------------");

		// TC4 with common parent at the end
		Commit commitA4 = new Commit("aaaa1",
				new Commit("aaaa2", new Commit("aaaaa3", new Commit("aaaa4", new Commit("aaaa5", null)))));
		Commit commitB4 = new Commit("bbbb1", new Commit("bbbb2", new Commit("aaaa4", null)));
		System.out.println(String.format("TestCase4: common parrent between commitA: %s and commitB: %s is:%s",
				commitA4, commitB4, findCommonParent(commitA4, commitB4)));
		System.out.println("------------------------------------------");

		// TC5 with common parent in the middle of the history
		Commit commitA5 = new Commit("aaaa1",
				new Commit("aaaa2", new Commit("aaaaa3", new Commit("aaaa4", new Commit("aaaa5", null)))));
		Commit commitB5 = new Commit("bbbb1", new Commit("bbbb2",
				new Commit("aaaa4", new Commit("bbbb3", new Commit("bbbb4", new Commit("bbbb5", null))))));
		System.out.println(String.format("TestCase5: common parrent between commitA: %s and commitB: %s is:%s",
				commitA5, commitB5, findCommonParent(commitA5, commitB5)));
	}

	public static Commit getParent(Commit commit) throws InterruptedException {
		if (commit.getParent() == null) {
			return null;
		}
		System.out.println(String.format("get parent for commit: %s", commit));
		Thread.sleep(5 * 1000);
		return commit.getParent();
	}

	public static Commit findCommonParent(Commit commitA, Commit commitB) throws InterruptedException {
		if (commitA == null || commitB == null) {
			return null;
		}

		Set<String> commitsHistory = new HashSet<>();
		while (commitA != null) {
			if (commitA.getHash() == null) {
				throw new IllegalArgumentException("Hash can't be NULL!");
			}
			if (commitsHistory.contains(commitA.getHash())) {
				return commitA;
			}
			commitsHistory.add(commitA.getHash());
			if (commitB == null) {
				return null;
			}
			if (commitB.getHash() == null) {
				throw new IllegalArgumentException("Hash can't be NULL!");
			}
			if (commitsHistory.contains(commitB.getHash())) {
				return commitB;
			}
			commitsHistory.add(commitB.getHash());

			commitA = getParent(commitA);
			commitB = getParent(commitB);
		}
		return null;

	}

}
