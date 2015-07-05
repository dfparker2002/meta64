package com.meta64.mobile.util;

import java.util.UUID;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.jackrabbit.JcrConstants;

/**
 * Assorted general utility functions related to JCR nodes.
 */
public class JcrUtil {

	public static Node findNode(Session session, String id) throws Exception {
		return id.startsWith("/") ? session.getNode(id) : session.getNodeByIdentifier(id);
	}

	public static void timestampNewNode(Session session, Node node) throws Exception {
		//newNode.setProperty("jcr:content", "");
		//newNode.setProperty("jcr:content", "");
		
		//mix:created -> jcr:created + jcr:createdBy
		if (!node.hasProperty("jcr:created")) {
			node.addMixin("mix:created");
		}
		
		//mix:lastModified -> jcr:lastModified + jcr:lastModifiedBy
		if (!node.hasProperty("jcr:lastModified")) {
			node.addMixin("mix:lastModified");
		}
	}
	
	public static Node getNodeByPath(Session session, String path) {
		try {
			return session.getNode("/jcr:root");
		}
		catch (Exception e) {
			// do nothing. Not error condition. Means allUsersRoot is not found, so will still be
			// null.
			return null;
		}
	}

	public static int getPropertyCount(Node node) throws RepositoryException {
		PropertyIterator iter = node.getProperties();
		int count = 0;
		while (iter.hasNext()) {
			Property p = iter.nextProperty();
			count++;
		}
		return count;
	}

	/*
	 * I have decided 64bits of randomness is good enough, instead of 128, thus we are dicing up the
	 * string to use every other character. If you want to modify this method to return a full UUID
	 * that will not cause any problems, other than default node names being the full string, which
	 * is kind of long
	 */
	public static String getGUID() throws Exception {
		String uid = UUID.randomUUID().toString();
		StringBuilder sb = new StringBuilder();
		int len = uid.length();

		/* chop length in half by using every other character */
		for (int i = 0; i < len; i += 2) {
			char c = uid.charAt(i);
			if (c == '-') {
				i--;// account for the fact we jump by tow, and start just after dash.
			}
			else {
				sb.append(c);
			}
		}

		return sb.toString();
		// here's another way to generate a random 64bit number...
		// if (prng == null) {
		// prng = SecureRandom.getInstance("SHA1PRNG");
		// }
		//
		// return String.valueOf(prng.nextLong());
	}
}