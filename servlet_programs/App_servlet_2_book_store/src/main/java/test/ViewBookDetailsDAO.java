package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewBookDetailsDAO {
	
	public BookBean bb = null;
	public BookBean retrieve(String bC)
	{
		try {
			Connection con = DBConnection.getCon(); //Accessing Connection Object
			
			PreparedStatement ps = con.prepareStatement("select * from BookDetails72 where code = ?");
			ps.setString(1,bC);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				bb = new BookBean();
				bb.setCode(rs.getString(1));
				bb.setName(rs.getString(2));
				bb.setAuthor(rs.getString(3));
				bb.setPrice(rs.getFloat(4));
				bb.setQty(rs.getInt(5));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return bb;	
	}
}
