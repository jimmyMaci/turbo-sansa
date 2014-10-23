package events.system.service.util;

import message.system.model.Messages;
import events.system.model.Categories;
import events.system.model.EventLocations;
import events.system.model.EventMessages;
import events.system.model.Topics;

public class HqlStringCreator {

	public static String forCategories(String name, Class<Categories> clazz) {
		StringBuilder sb = getSimpleSelect(clazz, true);
		String firstLetter = getFirstLetterLowerCase(clazz);
		boolean nameIsNotNull = name != null && !name.isEmpty();
		if (nameIsNotNull) {
			sb.append(" ");
			sb.append("where " + firstLetter + ".name=:name");
		}
		return sb.toString();
	}

	public static String forEventMessages(Messages message,
			EventLocations eventLocation, Class<EventMessages> clazz) {
		StringBuilder sb = getSimpleSelect(clazz, true);
		String firstLetter = getFirstLetterLowerCase(clazz);
		boolean messagesIsNotNull = message != null;
		if (messagesIsNotNull) {
			sb.append(" ");
			sb.append("where " + firstLetter + ".message=:message");
		}
		boolean eventLocationIsNotNull = eventLocation != null;
		if (eventLocationIsNotNull) {
			appendCondition(sb, "eventLocation", firstLetter, messagesIsNotNull);
		}
		return sb.toString();
	}
	
	public static String forTopics(String name,  Boolean node, Topics parent) {
		StringBuilder sb = HqlStringCreator.getSimpleSelect(Topics.class, true);
		String firstLetter = getFirstLetterLowerCase(Topics.class);
		boolean nameIsNotNull = name != null && !name.isEmpty();
		if(nameIsNotNull) {
			appendCondition(sb, "name", firstLetter, true);
		}
		boolean nodeIsNotNull = node != null;
		if( nodeIsNotNull ) {
			appendCondition(sb, "node", firstLetter, nameIsNotNull);						
		}
		boolean parentIsNotNull = parent != null;
		if(parentIsNotNull) {
			appendCondition(sb, "parent", firstLetter, nameIsNotNull, nodeIsNotNull);
		}
		return sb.toString();		
	}

	public static void appendCondition(StringBuilder sb, String fieldName, String firstLetter,
			boolean... isNotNull) {
		boolean concatenated = false;
		for (int i = 0; i < isNotNull.length; i++) {
			if(i == 0) {
				concatenated = !isNotNull[i];
				continue;
			}
			concatenated = concatenated && !isNotNull[i];
		}
		sb.append(" ");
		String condition = firstLetter + "." + fieldName + "=:"	+ fieldName;
		if (concatenated) {
			sb.append("where " + condition);
		} else {
			sb.append("and " + condition);
		}
	}

	public static StringBuilder getSimpleSelect(Class<?> clazz, boolean distinct) {
		StringBuilder sb = new StringBuilder();
		String firstLetter = getFirstLetterLowerCase(clazz);
		if(distinct) {
			sb.append("select distinct " + firstLetter + " from "
					+ clazz.getSimpleName() + " " + firstLetter);
		} else {
			sb.append("select " + firstLetter + " from "
					+ clazz.getSimpleName() + " " + firstLetter);
		}
		return sb;
	}
	
	public static String getFirstLetterLowerCase(Class<?> clazz) {
		String simpleClassName = clazz.getSimpleName();
		String firstLetter = simpleClassName.substring(0, 1).toLowerCase();
		return firstLetter;
	}
}
