package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;

public class Model {
    private CustomerDAO customerDAO;
    private FundDAO fundDAO;
    private PositionDAO positionDAO;

    public Model(ServletConfig config) throws ServletException {
        try {
            String jdbcDriver = config.getInitParameter("jdbcDriverName");
            String jdbcURL    = config.getInitParameter("jdbcURL");
            
            ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
            customerDAO = new CustomerDAO("Customer", pool);
            fundDAO = new FundDAO("Fund", pool);
            positionDAO = new PositionDAO("Position", pool);
        } catch (DAOException e) {
            throw new ServletException(e);
        }
    }
    
    public CustomerDAO getCustomerDAO() {
     	return customerDAO;
    }
    
    public FundDAO getFundDAO() {
        return fundDAO;
    }
    
	public PositionDAO getPositionDAO() {
		return positionDAO;
	}
}