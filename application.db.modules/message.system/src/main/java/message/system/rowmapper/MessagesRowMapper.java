package message.system.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import message.system.model.Messages;

import org.springframework.jdbc.core.RowMapper;

public class MessagesRowMapper implements RowMapper<Messages>  {

	@Override
	public Messages mapRow(ResultSet rs, int rowNum) throws SQLException {
		Messages messages = new Messages();
		messages.setId(rs.getInt(1));
		messages.setFailed2sentemail(rs.getBoolean(2));
		messages.setFolder(rs.getString(3));
		messages.setMessageContent(rs.getString(4));
//		messages.setMessagetype(messagetype)//
		return messages;
	}

}
