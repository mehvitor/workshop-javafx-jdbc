package model.dao;

import db.ConexaoDB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(ConexaoDB.getConexao());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(ConexaoDB.getConexao());
	}
}
