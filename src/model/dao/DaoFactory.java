package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao creatSallerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
}
